package Lesson13;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// урок "Работа с файлами"
public class Lesson13Test {

    @Test
    @DisplayName("Тест на скачивание файла")
    public void SelenideDownloadTest() throws Exception {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/junit-team/junit-framework");
        getWebDriver().manage().window().maximize();

        File downloadedFile = $$("a[title=\"README.md\"]").get(1).download();
        try (InputStream is = new FileInputStream(downloadedFile)) {
            byte[] bytes = is.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of JUnit Platform, Jupiter, and Vintage");
        }
    }

    @Test
    @DisplayName("Загрузка файла")
    public void SelenideUploadFile() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        open("https://imgur.com/");
        getWebDriver().manage().window().maximize();

        $("a.Button.upload[data-discover=\"true\"]").click();
        $("input#file-input").uploadFromClasspath("sa-mp-000.png");
    }

    @Test
    @DisplayName("Тест парсинга PDF-документа")
    public void PdfParseTest() throws Exception {
        Configuration.holdBrowserOpen = true;
        open("https://junit.org/junit5/docs/current/user-guide/");
        getWebDriver().manage().window().maximize();

        File downloadedPDF = $("a[href=\"junit-user-guide-6.0.1.pdf\"]").download();

        PDF content = new PDF(downloadedPDF);
        assertThat(content.author).contains("Sam Brannen");
    }

    ClassLoader cl = Lesson13Test.class.getClassLoader(); // получаем класслоадер
    @Test
    @DisplayName("Тест парсинга EXEL-документа")
    public void xlsParseTest() throws Exception {
        try (InputStream resourceAsStream = cl.getResourceAsStream("sample3.xlsx")) {
            XLS content = new XLS(resourceAsStream);
            Cell cell = content.excel.getSheetAt(0).getRow(1).getCell(1);
            assertThat(cell.getStringCellValue()).contains("January");
        }
    }

    @Test
    @DisplayName("Тест парсинга csv-документа")
    public void csvParseTest() throws Exception {
        try (InputStream resource = cl.getResourceAsStream("testData.csv");
        CSVReader reader =new CSVReader(new InputStreamReader(resource)))
        {
            List<String[]> content = reader.readAll();
            assertThat(content.get(0)[2]).contains("alan.dzhigkaevv@mail.ru");
        }
    }

    @Test
    @DisplayName("Тест парсинга zip-архива")
    public void zipParseTest() throws Exception {
        try (InputStream resource = cl.getResourceAsStream("archive.zip");
             ZipInputStream zis = new ZipInputStream(resource)
            )
        {
            ZipEntry entry;
            while((entry = zis.getNextEntry()) != null){
                assertThat(entry.getName()).isEqualTo("Mall_Customers.csv");
            }
        }
    }

    @Test
    @DisplayName("Тест парсинга json")
    public void jsonParseTest() {
        Gson gson = new Gson();
        try (InputStream resource = cl.getResourceAsStream("glossary.json");
             InputStreamReader reader = new InputStreamReader(resource)
        ) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            // Получаем объект "glossary" сначала
            JsonObject glossary = jsonObject.getAsJsonObject("glossary");

            // Теперь обращаемся к полям внутри glossary
            assertThat(glossary.get("title").getAsString()).isEqualTo("example glossary");

            // Получаем GlossDiv и затем его title
            JsonObject glossDiv = glossary.getAsJsonObject("GlossDiv");
            assertThat(glossDiv.get("title").getAsString()).isEqualTo("S");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package pages.components;

import java.time.Month;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String year,String month,String day){
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month .react-datepicker__day--0"+day).click();
    }
}

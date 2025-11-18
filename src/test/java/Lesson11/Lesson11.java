package Lesson11;

import org.junit.jupiter.api.Test;

// Основы Java часть 2
public class Lesson11 {
    @Test
    public static void lesson11() {
        String[] arrayStr = new String[]{"Dima", "Vasya"};

        int[] array = {100, 150, -1};

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        int index = 0;
        while (index< array.length){
            System.out.println(array[index]);
            index++;
        }
    }
    public static void main(String[] args) {
        lesson11(); // вызываем ваш метод
    }
}

package Lesson11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class HomeWork {
    public static class HomeWork1 {
        private HashMap<Integer, String> users = new HashMap<>();

        public void addUser(int id, String name) {
            users.put(id, name);
            System.out.println("Добавлен пользователь "+name+". Его id = "+id);
        }

        public void removeUser(int id) {
            System.out.println("Вы вызвали метод удаления пользователя с ID = "+id+". Пользователь с именем "+users.remove(id)+
                    " удален");
            users.remove(id);
        }

        public String findUser(int id) {
            System.out.println("Вы вызвали метод получения пользователя с ID = "+id+". Этот пользователь - "+users.get(id));
            return users.get(id);
        }

        public void printAll() { // public - метод можно вызвать из других классов, void - метод не возвращает никаких данных
            System.out.println("Список пользователей:");
            for (Map.Entry<Integer, String> entry : users.entrySet()) { //
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static class HomeWork2{
        String[] users = {"Alan","Igor","Makaka","Vika"};

        public void printAllUsers(){
            System.out.println("Задание №2. Цикл for. Вывод все юзеров из массива.");
            System.out.println("Массив: "+ Arrays.toString(users));
            for (int i=0; i< users.length;i++){
                System.out.println(users[i]);
            }
        }
    }

    public static class HomeWork3{
        private List<String> fruits = new ArrayList<>();

        public void AddFruit(String name){
            fruits.add(name);
            System.out.println("Фрукт "+name+" добавлен");
        }

        public void PrintAllFruits(int index) {
            System.out.println("Вывод всех фркутов из List<String>.");
            while (index < fruits.size()) {
                System.out.println("Фрукт: " + fruits.get(index));
                index++;
            }
        }
    }

    public static class HomeWork4{
        public void DoWhileCycle(int i,int count){
            System.out.println("Задание №4. Цикл Do while.");
            do {
                System.out.println("Итерация: "+i);
                i++;
            } while (i<count);
        }
    }

    public static void main(String[] args) {
        HomeWork1 app = new HomeWork1(); // Создаем объект внутреннего класса
        app.addUser(1, "Alan");
        app.addUser(2, "Igor");
        app.addUser(3, "Vika");
        app.addUser(4, "Makaka");
        app.findUser(3);
        app.removeUser(3);
        app.printAll();

        System.out.println("");
        HomeWork2 app2 = new HomeWork2();
        app2.printAllUsers();

        System.out.println("");
        System.out.println("Задание №3. Цикл while. Вывод всех фркутов из List<String>.");
        HomeWork3 app3 = new HomeWork3();
        app3.AddFruit("Апельсин");
        app3.AddFruit("Яблоко");
        app3.AddFruit("Банан");
        app3.AddFruit("Груша");
        app3.PrintAllFruits(0);

        System.out.println("");
        HomeWork4 app4 = new HomeWork4();
        app4.DoWhileCycle(0,6);
    }
}
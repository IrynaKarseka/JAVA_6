// Подумать над структурой класса Ноутбук для магазина техники 
// выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии)
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
// хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить
// параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
// условиям.

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static LinkedList<SmartBook> databaseSmartBooks = new LinkedList<>();

    public static void main(String[] args) {
        SmartBook smartBook1 = new SmartBook("HP", 32, 128, "Windows xp", "Black");// 1-й экземпляр
        SmartBook smartBook2 = new SmartBook("Samsung", 128, 256, "Windows 7", "Red");// 2-й экземпляр
        SmartBook smartBook3 = new SmartBook("Honor", 256, 512, "Windows 8", "Gray");// 3-й экземпляр
        SmartBook smartBook4 = new SmartBook("Acer", 512, 512, "Windows 10", "Green");// 4-й экземпляр
        SmartBook smartBook5 = new SmartBook("Asus", 1024, 1024, "Windows 11", "Black");// ┐
        SmartBook smartBook6 = new SmartBook("Asus", 1024, 1024, "Windows 11", "Black");// ├ одинаковые
        SmartBook smartBook7 = new SmartBook("Asus", 1024, 1024, "Windows 11", "Black");// ┘

        databaseSmartBooks.add(smartBook1);
        databaseSmartBooks.add(smartBook2);
        databaseSmartBooks.add(smartBook3);
        databaseSmartBooks.add(smartBook4);
        databaseSmartBooks.add(smartBook5);
        databaseSmartBooks.add(smartBook6);
        databaseSmartBooks.add(smartBook7);

        getCriteria();
    }

    public static void getCriteria() {
        HashSet<SmartBook> sortSmartBooks = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> setCriteria = new HashSet<>();
        System.out.println("""

                            Добро пожаловать  магазин техники ** Ноутбук **
                Чтобы подобрать ноутбук введите цифру, соответствующую необходимому критерию:
                    1 - Объём ОЗУ
                    2 - Объём жесткого диска""" +
        /* 3 - Цвет ноутбука + */
                """

                            0 - Все
                        "Выберете опцию:""");
        int count = 1;
        int criteria;
        while (count < 3) {

            criteria = scanner.nextInt();
            if (criteria == 0) {
                if (count == 1) {
                    setCriteria.add(9);
                    break;
                } else {
                    setCriteria.add(0);
                    break;
                }
            }
            if (criteria != 1 && criteria != 2 && criteria != 3) {
                System.out.print("Таких значений нет " + criteria);
            } else {
                setCriteria.add(criteria);
                count++;
            }
        }
        for (int criterias : setCriteria) {

            switch (criterias) {

                case 1 -> {
                    System.out.print("Введите минимальное значение объема ОЗУ (например: 128 или 512): ");
                    int minVal = scanner.nextInt();
                    for (SmartBook smartBook : databaseSmartBooks) {
                        if (smartBook.getRam() >= minVal) {
                            sortSmartBooks.add(smartBook);
                        }
                    }
                }

                case 2 -> {
                    System.out.print("Введите минимальное значение объема жесткого диска (например: 256 или 1024): ");
                    int minVal = scanner.nextInt();
                    for (SmartBook smartBook : databaseSmartBooks) {
                        if (smartBook.getStorageCapacity() >= minVal) {
                            sortSmartBooks.add(smartBook);
                        }
                    }
                }

                case 9 -> {
                    for (SmartBook smartBook : databaseSmartBooks) {
                        System.out.println(smartBook);
                    }
                }
                default -> {
                    System.out.println("");
                }
            }
        }
        for (SmartBook smartBooks : sortSmartBooks) {
            System.out.println(smartBooks);
        }
    }
}

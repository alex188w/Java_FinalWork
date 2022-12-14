import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
 * методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или
 * критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии
 * фильтрации можно хранить в Map. Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * Далее нужно запросить минимальные значения для указанных критериев -
 * сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
 * условиям.
 */

public class Main {
    public static void main(String[] args) {

        Map<Integer, Notebook> mapNotes = new HashMap<>();
        Notebook note1 = new Notebook(2, 256, "Win 11", "silber");
        Notebook note2 = new Notebook(4, 256, "Win 10", "red");
        Notebook note3 = new Notebook(8, 512, "Win 10", "green");
        Notebook note4 = new Notebook(8, 512, "Win 11", "silber");
        Notebook note5 = new Notebook(16, 1024, "Win 11", "red");
        Notebook note6 = new Notebook(16, 1024, "Win 11", "green");
        Notebook note7 = new Notebook(32, 1024, "Mac OS", "silber");
        Notebook note8 = new Notebook(32, 1024, "Linux", "red");

        mapNotes.put(1, note1);
        mapNotes.put(2, note2);
        mapNotes.put(3, note3);
        mapNotes.put(4, note4);
        mapNotes.put(5, note5);
        mapNotes.put(6, note6);
        mapNotes.put(7, note7);
        mapNotes.put(8, note8);

        System.out.println("Список доступных моделей ноутбуков: (ОЗУ, объём SSD, операционная система, цвет): ");
        for (var item : mapNotes.entrySet()) {
            System.out.printf("\n[%d: %s]\n", item.getKey(), item.getValue());
        }

        Notebook noteUser = new Notebook(0, 0, null, null);
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println(
                "Нажмите '1', если есть минимальные требования по размеру ОЗУ, если нет, нажмите любую другую цифру ");

        if (sc.nextInt() == 1) {
            System.out.println("Введите минимальные требования по размеру ОЗУ ");
            noteUser.ramSize = sc.nextInt();
        }
        System.out.println(
                "Нажмите '2', если есть минимальные требования по размеру SSD, если нет, нажмите любую другую цифру ");

        if (sc.nextInt() == 2) {
            System.out.println("Введите минимальные требования по размеру SSD ");
            noteUser.driveSize = sc.nextInt();
        }
        System.out.println("Нажмите '3', если есть пожелания по типу ОС, если нет, нажмите любую другую цифру ");

        Scanner sc1 = new Scanner(System.in);
        if (sc.nextInt() == 3) {
            System.out.println("Введите требования по типу ОС (доступны: 'Win 10', 'Win 11', 'Mac OS', 'Linux') ");
            noteUser.osType = sc1.nextLine();
        }
        System.out.println("Нажмите '4', если есть пожелание по цвету ноутбука, если нет, нажмите любую другую цифру ");

        if (sc.nextInt() == 4) {
            System.out.println("Введите желаемый цвет ноутбука (доступны: 'silber', 'red', 'green') ");
            noteUser.color = sc1.nextLine();
        }

        System.out.println("Вы выбрали ноутбук со следующей конфигурацией: \n" + noteUser); // сохраненная желаемая
                                                                                            // конфигурация

        System.out.println("\n Вам подходят следующие модели ноутбуков: ");
        // В коллекции choiceMap сохраняем доступные для выбора ноутбуки
        Map<Integer, Notebook> choiceMap = new HashMap<>();
        int count = 0;
        for (var item : mapNotes.entrySet()) {
            if (item.getValue().equals(noteUser)) {
                choiceMap.put(item.getKey(), item.getValue());
                System.out.printf("\n[%d: %s]\n", item.getKey(), item.getValue());
                count++;
            }
        }
        if (count == 0)
            System.out.println("К сожалению, по Вашим критериям нет подходящих ноутбуков");
    }
}

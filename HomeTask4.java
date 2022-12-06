import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class HomeTask4 {

    static ArrayList<String> firstNames = new ArrayList<>();
    static ArrayList<String> middleNames = new ArrayList<>();
    static ArrayList<String> lastNames = new ArrayList<>();
    static ArrayList<Integer> ages = new ArrayList<>();
    /*
        Также как и количество разновидностей полов у людей кажется равным двум,
        Вариативность значений типа Boolean тоже кажется равной двум.
        В обоих случаях это не так. Не соответствует действительности.
        Boolean может принимать не два, а три значения: true, false и null.
        Также и среди людей встречаются интерсекс вариации: XXY
     */
    static ArrayList<Boolean> sexes = new ArrayList<>();
    static ArrayList<Integer> indexes = new ArrayList<>();

    static int currentIndex = 0;

    static String readLine(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    static void addRecord(Scanner scanner) {
        firstNames.add(
                readLine(scanner, "Введите фамилию")
        );
        lastNames.add(
                readLine(scanner, "Введите имя")
        );
        middleNames.add(
                readLine(scanner, "Введите отчество")
        );
        ages.add(
                Integer.parseInt(readLine(scanner, "Введите возраст"))
        );
        String s = readLine(scanner, "Введите пол(F/M)").toLowerCase(Locale.ROOT);
        sexes.add(
                s.startsWith("f") || s.startsWith("ж")
        );

        indexes.add(currentIndex);
        currentIndex++;
    }

    static int showMenu(Scanner scanner) {
        System.out.println("Достпуные опции: ");
        System.out.println("1 - Добавить запись");
        System.out.println("2 - Вывести все записи");
        System.out.println("3 - Сортировать по возрасту");
        System.out.println("0 - Выйти");

        return Integer.parseInt(readLine(scanner, "Введите номер операции: "));
    }

    static void sortByAge() {
        int size = indexes.size();
        for (int index1 = 0; index1 < size; index1++) {
            for (int index2 = 1; index2 < (size - index1); index2++) {
                if (ages.get(indexes.get(index2 - 1)) > ages.get(indexes.get(index2))) {
                    swapIndexes(indexes.get(index2 - 1), indexes.get(index2));
                }
            }
        }
    }

    static void swapIndexes(int index1, int index2) {
        int pointer1 = indexes.indexOf(index1);
        int pointer2 = indexes.indexOf(index2);
        indexes.remove(pointer1);
        indexes.add(pointer1, index2);
        indexes.remove(pointer2);
        indexes.add(pointer2, index1);
    }

    static void printAllRecords() {
        for (int index : indexes) {
            printRecord(index);
        }
    }

    static void printRecord(int index) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ФИО: ");
        stringBuilder.append(firstNames.get(index));
        stringBuilder.append(" ");
        stringBuilder.append(lastNames.get(index));
        stringBuilder.append(" ");
        stringBuilder.append(middleNames.get(index));
        stringBuilder.append(" Возраст: ");
        stringBuilder.append(ages.get(index).toString());
        if (sexes.get(index)) {
            stringBuilder.append(" Пол: женский");
        } else {
            stringBuilder.append(" Пол: мужской");
        }
        System.out.println(stringBuilder);
    }

    static void setupDefaults() {
        firstNames.add("Казаков");
        firstNames.add("Ефимова");
        firstNames.add("Сенатская");
        lastNames.add("Дмитрий");
        lastNames.add("Ольга");
        lastNames.add("Евгения");
        middleNames.add("Иванович");
        middleNames.add("Игоревна");
        middleNames.add("Александровна");
        ages.add(30);
        ages.add(28);
        ages.add(29);
        sexes.add(false);
        sexes.add(true);
        sexes.add(true);
        indexes.add(0);
        indexes.add(1);
        indexes.add(2);
        currentIndex = 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        setupDefaults();
        boolean running = true;
        while (running) {
            int option = showMenu(scanner);
            switch (option) {
                case 1: {
                    addRecord(scanner);
                    break;
                }
                case 2: {
                    printAllRecords();
                    break;
                }
                case 3: {
                    sortByAge();
                    printAllRecords();
                    break;
                }
                case 0: {
                    running = false;
                    break;
                }
            }
        }
        scanner.close();
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Урок 3. Коллекции JAVA: Введение
1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
3. Вставить элемент в список в первой позиции.
4. Извлечь элемент (по указанному индексу) из заданного списка.
5. Обновить определенный элемент списка по заданному индексу.
6. Удалить третий элемент из списка.
7. Поиска элемента в списке по строке.
8. Создать новый список и добавить в него несколько елементов первого списка.
9. Удалить из первого списка все элементы отсутствующие во втором списке.
10*. Сортировка списка.
11*. Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.
 */
public class HomeWork3 {

    static ArrayList<String> colors = new ArrayList<String>(
            Arrays.asList("Красный", "Оранжевый", "Желтый", "Зеленый", "Синий", "Фиолетовый"));

    static String readLine(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
        ArrayList<String> myList = new ArrayList<>();
        myList.add("The Rose is a threat");
        myList.add("The Worm is a cure");
        myList.add("The Rose and the Worm - are the same");
        System.out.println("My list: " + Arrays.toString(myList.toArray()));

        // 2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
        List<String> mappedColors = colors.stream().map(color -> "!" + color)
                .collect(Collectors.toList());
        System.out.println("Mapped colors: " + Arrays.toString(mappedColors.toArray()));

        // 3. Вставить элемент в список в первой позиции.
        myList.add(0, "Message repeats");
        System.out.println("My list first element added: " + Arrays
                .toString(myList.toArray()));

        // 4. Извлечь элемент (по указанному индексу) из заданного списка.
        int showIndex = Integer.parseInt(readLine(scanner, "Enter index to show: "));
        System.out.println(myList.get(showIndex));

        // 5. Обновить определенный элемент списка по заданному индексу.
        int updateIndex = Integer.parseInt(readLine(scanner, "Enter index to update: "));
        String update = readLine(scanner, "Enter an updating string: ");
        myList.remove(updateIndex);
        myList.add(updateIndex, update);
        System.out.println("Updated list: " + Arrays
                .toString(myList.toArray()));

        // 6. Удалить третий элемент из списка.
        if (myList.size() > 2) {
            myList.remove(2);
        }
        System.out.println("The third element removed: " + Arrays
                .toString(myList.toArray()));

        // 7. Поиска элемента в списке по строке.
        String search = readLine(scanner, "Enter a string to search: ");
        List<String> found = myList.stream().filter(str -> str.contains(search)).collect(Collectors.toList());
        System.out.println("Elements found: " + Arrays
                .toString(found.toArray()));

        // 8. Создать новый список и добавить в него несколько елементов первого списка.
        ArrayList<String> newList = new ArrayList<>();
        newList.addAll(myList.subList(0, 2));
        System.out.println("New list with elements from previous one: " + Arrays
                .toString(newList.toArray()));

        // 9. Удалить из первого списка все элементы отсутствующие во втором списке.
        myList.retainAll(newList);
        System.out.println("Removed elements missing in the second list: " + Arrays
                .toString(myList.toArray()));
    }
}
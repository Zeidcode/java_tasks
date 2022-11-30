

import java.util.Scanner;

/*
    Урок 2. Почему вы не можете не использовать API
    1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы
    другой строки.
    2. Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением
    друг друга.
    3*. Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
    4. Дано два числа, например 3 и 56, необходимо составить следующие строки:
    3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
    5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),
    StringBuilder.deleteCharAt().
    6*. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
    7**. Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "="
    средствами String и StringBuilder.
 */
public class HomeWork2 {

    static final int CHARS_NUMBER = 256;
    static final String NO_WINDOW_FOUND = "no window matches";

    // https://progler.ru/blog/naydite-naimenshee-okno-v-stroke-soderzhaschey-vse-simvoly-drugoy-stroki
    static String leastSubstringWindow(
            String str,
            String pat
    ) {
        int len1 = str.length();
        int len2 = pat.length();

        if (len1 < len2) {
            return NO_WINDOW_FOUND;
        }

        int[] hash_pat = new int[CHARS_NUMBER];
        int[] hash_str = new int[CHARS_NUMBER];

        for (int i = 0; i < len2; i++) {
            hash_pat[pat.charAt(i)]++;
        }

        int start = 0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int count = 0;

        for (int j = 0; j < len1; j++) {
            hash_str[str.charAt(j)]++;

            if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)]) {
                count++;
            }

            if (count == len2) {
                while (hash_str[str.charAt(start)]
                        > hash_pat[str.charAt(start)]
                        || hash_pat[str.charAt(start)]
                        == 0) {

                    if (hash_str[str.charAt(start)]
                            > hash_pat[str.charAt(start)])
                        hash_str[str.charAt(start)]--;
                    start++;
                }

                int len_window = j - start + 1;
                if (minLength > len_window) {
                    minLength = len_window;
                    startIndex = start;
                }
            }
        }

        if (startIndex == -1) {
            return NO_WINDOW_FOUND;
        }

        return str.substring(startIndex, startIndex + minLength);
    }

    // https://translated.turbopages.org/proxy_u/en-ru.ru.e0c7cd76-6384c54f-e482ad95-74722d776562/https/www.geeksforgeeks.org/java-program-to-check-if-strings-are-rotations-of-each-other-or-not-set-2/
    public static boolean isCoRotation(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (n != m)
            return false;

        int[] lps = new int[n];

        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < n) {
            if (a.charAt(i) == b.charAt(len)) {
                lps[i] = ++len;
                ++i;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    ++i;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        i = 0;

        for (int k = lps[n - 1]; k < m; ++k) {
            if (b.charAt(k) != a.charAt(i++))
                return false;
        }
        return true;
    }

    static String rotateStringRecursive(String str) {
        if (str.length() < 2) {
            return str;
        } else {
            return str.substring(str.length() - 1, str.length()) +
                    rotateStringRecursive(str.substring(1, str.length() - 1)) +
                    str.substring(0, 1);
        }
    }

    static String readLine(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы
        другой строки.
       */
        String wholeString = readLine(scanner, "Enter the whole string: ");
        String subString = readLine(scanner, "Enter a substring to find: ");
        String minWindow = leastSubstringWindow(wholeString, subString);
        System.out.println("Least substring window: " + minWindow);

        /*
        2. Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением
        друг друга.
         */
        String first = readLine(scanner, "Enter the first string: ");
        String second = readLine(scanner, "Enter the second string: ");
        boolean coRotation = isCoRotation(first, second);
        System.out.println("Strings are co-rotation: " + coRotation);

        /*
        3*. Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
         */
        String inputString = readLine(scanner, "Enter a string to rotate: ");
        String rotated = rotateStringRecursive(inputString);
        System.out.println("Rotated string: " + rotated);

        /*
        4. Дано два числа, например 3 и 56, необходимо составить следующие строки:
        3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
         */
        int firstNum = Integer.parseInt(readLine(scanner, "Enter the first number: "));
        int secondNum = Integer.parseInt(readLine(scanner, "Enter the second number: "));

        StringBuilder builder = new StringBuilder();
        builder.append(firstNum);
        builder.append(" + ");
        builder.append(secondNum);
        builder.append(" = ");
        builder.append(firstNum + secondNum);
        builder.append(" ");
        builder.append(firstNum);
        builder.append(" - ");
        builder.append(secondNum);
        builder.append(" = ");
        builder.append(firstNum - secondNum);
        builder.append(" ");
        builder.append(firstNum);
        builder.append(" * ");
        builder.append(secondNum);
        builder.append(" = ");
        builder.append(firstNum * secondNum);
        System.out.println(builder);

        /*
          5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),
            StringBuilder.deleteCharAt().
         */
        int index = builder.indexOf("=");
        while (index != -1) {
            builder.deleteCharAt(index);
            builder.insert(index, "равно");
            index = builder.indexOf("=");
        }
        System.out.println(builder);
    }
}
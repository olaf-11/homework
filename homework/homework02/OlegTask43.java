/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 4.3. (Тема: Циклы, массивы)
 * Выполнить сортировку массива с числами.
 * Пишем следующие алгоритмы:
 * --> Пузырьковая сортировка
 * --> Шейкерная сортировка
 *
 * После каждой сортировки в консоли у вас должно получиться
 * "[Какой массив был до сортировки] -> [Каким стал массив после сортировки]".
 * Для вывода можно использовать Arrays.
 *
 * Написать код который будет создавать массив руками через консоль.
 */
package homework02;
import static homework02.OlegTask41.bubbleSort;
import static homework02.OlegTask41.shakerSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OlegTask43 {
    public static void main(String[] args) throws IOException {
        //
        System.out.println("Введите набор целых чисел, через запятую и пробел." +
                "\nНапример, 3, -5, 56, 23, 99456, 0");
        // Тестовый ввод:
        // -5, 789, 0, -24, 18, 62, 38, 624, -224, -67, 45, 107, 204, -851, 253, 77, -914
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(", ");

        int[] bArray = new int [numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            bArray[i] = Integer.parseInt(numbers[i]);
        }

        //

        System.out.println("\nПузырьковая сортировка ----------------------------------------------->");
        System.out.println("\nИсходный массив      -> " + Arrays.toString(bArray));
        bubbleSort(bArray);
        System.out.println("Сортированный массив -> " + Arrays.toString(bArray));
        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            bArray[i] = Integer.parseInt(numbers[i]);
        }
        //

        System.out.println("Шейкерная сортировка ------------------------------------------------->");
        System.out.println("\nИсходный массив      -> " + Arrays.toString(bArray));
        shakerSort(bArray);
        System.out.println("Сортированный массив -> " + Arrays.toString(bArray));
        System.out.println();
    }
}
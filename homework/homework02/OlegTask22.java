/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 2.2. (Тема: Циклы, массивы)
 * Вывести каждый второй элемент массива в консоль
 */
package homework02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OlegTask22 {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите набор целых чисел, через запятую и пробел." +
                "\nНапример, 3, -5, 56, 23, 99456, 0");
        // Тестовый ввод:
        // 1, 22, 3, 44, 5, 66, 7, 88, 9, 1010, 11, 1212
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(", ");

        int[] arr = new int [numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr [i] = Integer.parseInt(numbers[i]);
        }

        System.out.println("\nВывод каждого 2-го значения массива: ");
        for (int i = 1; i < arr.length; i += 2) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}

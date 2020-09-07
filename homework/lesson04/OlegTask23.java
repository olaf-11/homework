/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 2.3. (Тема: Циклы, массивы)
 * Вывести все элементы массива в консоль в обратном порядке.
 * Элементы массива вводить через консоль. Массив хранит в себе числа.
 * Выводить при помощи:
 *      2.3.1. do....while
 *      2.3.2. while
 *      2.3.3. for
 *      2.3.4. foreach.
 */
package lesson04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OlegTask23 {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите набор целых чисел, через запятую и пробел." +
                "\nНапример, 3, -5, 56, 23, 99456, 0");
        // Тестовый ввод:
        // -5, 789, 0, -24, 18, 67, 38, 98624, -224
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(", ");

        int[] arr = new int [numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr [i] = Integer.parseInt(numbers[i]);
        }

        // 2.3.1. do....while
        System.out.println("\nВывод значений массива через do-while (обратный порядок): ");
        int i = arr.length - 1;
        do {
            System.out.print(arr[i] + "  ");
            i--;
        } while (i >= 0);
        System.out.println();

        // 2.3.2. while
        System.out.println("\nВывод значений массива через while (обратный порядок): ");
        i = arr.length - 1;
        while (i >= 0) {
            System.out.print(arr[i] + "  ");
            i--;
        }
        System.out.println();

        // 2.3.3. for
        System.out.println("\nВывод значений массива через for (обратный порядок): ");
        for (i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

        // 2.3.4. foreach
        System.out.println("\nВывод значений массива через foreach (обратный порядок): ");
        // "Перевернём" массив
        int temp;
        for (int j = 0; j < arr.length / 2; j++) {
            temp = arr[j];
            arr[j] = arr[arr.length - 1 - j];
            arr[arr.length - 1 - j] = temp;
        }
        for (int num: arr) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }
}

/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 2.1. (Тема: Циклы, массивы)
 * Вывести все элементы в консоль. Элементы массива вводить через консоль.
 * Массив хранит в себе числа. Выводить при помощи:
 *      2.1.1. do....while
 *      2.1.2. while
 *      2.1.3. for
 *      2.1.4. foreach.
 */
package lesson04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OlegTask21 {
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

        // 2.1.1. do....while
        System.out.println("\nВывод значений массива через do-while: ");
        int i = 0;
        do {
            System.out.print(arr[i] + "  ");
            i++;
        } while (i < arr.length);
        System.out.println();

        // 2.1.2. while
        System.out.println("\nВывод значений массива через while: ");
        i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + "  ");
            i++;
        }
        System.out.println();

        // 2.1.3. for
        System.out.println("\nВывод значений массива через for: ");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

        // 2.1.4. foreach
        System.out.println("\nВывод значений массива через foreach: ");
        for (int num: arr) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }
}

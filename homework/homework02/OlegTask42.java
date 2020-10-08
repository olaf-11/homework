/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 4.2. (Тема: Циклы, массивы)
 * Выполнить сортировку массива с числами.
 * Пишем следующие алгоритмы:
 * --> Пузырьковая сортировка
 * --> Шейкерная сортировка
 *
 * После каждой сортировки в консоли у вас должно получиться
 * "[Какой массив был до сортировки] -> [Каким стал массив после сортировки]".
 * Для вывода можно использовать Arrays.
 *
 * Написать код который будет создавать массив рандомной длинны,
 * заполнять массив рандомными числами.
 */
package homework02;
import static homework02.OlegTask41.bubbleSort;
import static homework02.OlegTask41.shakerSort;

import java.util.Arrays;
import java.util.Random;

public class OlegTask42 {
    public static void main(String[] args) {
        //
        Random rnd = new Random();
        int[] bArray = new int[rnd.nextInt(18)];
        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = rnd.nextInt(2000) - 1000;
        }

        System.out.println("\nПузырьковая сортировка ----------------------------------------------->");
        System.out.println("\nИсходный массив      -> " + Arrays.toString(bArray));
        bubbleSort(bArray);
        System.out.println("Сортированный массив -> " + Arrays.toString(bArray));
        System.out.println();

        bArray = new int[rnd.nextInt(15)];
        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = rnd.nextInt(2000) - 1000;
        }

        System.out.println("Шейкерная сортировка ------------------------------------------------->");
        System.out.println("\nИсходный массив      -> " + Arrays.toString(bArray));
        shakerSort(bArray);
        System.out.println("Сортированный массив -> " + Arrays.toString(bArray));
        System.out.println();
    }
}
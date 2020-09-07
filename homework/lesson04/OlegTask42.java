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
package lesson04;

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

    /**
     * Метод выполняет "пузырьковую" сортировку массива @param array
     */
    public static void bubbleSort (int[] array) {
        if(array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                boolean isSwap = false;
                for (int j = array.length - 1; j > i; j--) {
                    if (array[j - 1] > array[j]) {
                        isSwap = swapIt(array, j - 1, j);
                    }
                }
                if (!isSwap) break; // Если не было перестановок
            }
        }
    }

    /**
     * Метод выполняет "шейкерную" сортировку массива @param array
     */
    public static void shakerSort (int[] array) {
        if(array.length > 1) {
            //
            boolean isSwap;
            int left = 0;
            int right = array.length -1;

            do {
                isSwap = false;

                for (int i = ++left; i <= right; i++) {
                    if (array[i - 1] > array[i]) {
                        isSwap = swapIt(array, i - 1, i);
                    }
                }

                if (!isSwap) break; // Если не было перестановок

                isSwap = false;

                for (int i = --right; i >= left; i--) {
                    if (array[i - 1] > array[i]) {
                        isSwap = swapIt(array, i - 1, i);
                    }
                }

            } while(isSwap && (right > left));
        }
    }

    /**
     * Метод получает массив @param arr и индексы @param i и @param j.
     * Меняет местами значения элементов массива arr[i] и arr[j]
     * @return true всегда, если был вызван.
     */
    public static boolean swapIt (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return true;
    }
}
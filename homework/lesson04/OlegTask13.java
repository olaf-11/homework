/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 1.3. (Тема: Циклы, массивы)
 * Возведение в степень.
 * Через консоль пользователь вводит два числа.
 * Первое число это число которое мы будем возводить, может быть отрицательным и дробным.
 * Второе число это степень в которую возводят первое число
 * Степень - только положительная и целая.
 */
package lesson04;

import java.util.Scanner;

public class OlegTask13 {
    public static void main(String[] args) {
        double base = 0.0;
        int power = -1;
        double multi = 1.0;

        System.out.println("Вычислим степень числа.");

        // XXXXXXX переделать Scanner для проверок строк RegExp int[\\d+] double[\\d+(,|.)\\d+]
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите основание (не 0; вещественное число разделяйте запятой (,) ): ");
            if (sc.hasNextDouble()){
                base = sc.nextDouble();
            }
            if (base != 0.0) break;
        }

        while (true) {
            System.out.print("\nВведите степень числа (положительное целое число): ");
            if (sc.hasNextInt()){
                power = sc.nextInt();
            }
            if (power >= 0) break;
        }

        sc.close();

        switch (power) {
            case 0:
                multi = 1;
                break;
            case 1:
                multi = base;
                break;
            default:
                for (int i = 0; i < power; i++) {
                    multi *= base;
                }
                break;
        }

        System.out.println("(" + base + " в степени " + power + ") = " + multi);
    }
}

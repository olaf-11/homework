/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 3. (Тема: операторы)
 * Изучить библиотеку (класс) Math из jdk.
 * (https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
 */
package lesson02;

public class OlegTask3 {
    public static void main(String[] args) {

        /* Округление к наибольшему и наименьшему целому. */
        double d = -17.5012;
        System.out.println("Округление к наибольшему целому (" + d + "): " + Math.ceil(d));
        System.out.println("Округление к наименьшему целому (" + d + "): " + Math.floor(d));

        /* Округление числа по модулю к наибольшему и наименьшему целому. */
        System.out.println("\nОкругление к наибольшему целому (abs(" + d + ")): " + Math.ceil(Math.abs(d)));
        System.out.println("Округление к наименьшему целому (abs(" + d + ")): " + Math.floor(Math.abs(d)));


        /* Нибольшее и наименьшее число из пары. */
        double f = 32.053;
        System.out.println("\nБольшее число (" + f + " , " + d + "):  " + Math.max(d, f));
        System.out.println("Меньшее число (" + f + " , " + d + "): " + Math.min(d, f));

        /* Корень квадратный числа. */
        double g = 625;
        System.out.println("\nКорень квадратный числа " + (int) g + ": " + Math.sqrt(g));

        /* Степень числа. */
        System.out.println("2 в степени 16 = " + (int) Math.pow(2, 16));

        /* Тригонометрический функции cos и sin */
        System.out.println("\nsin числа PI/2: " + Math.sin(Math.PI / 2));
        System.out.println("cos числа PI/2: " + Math.floor(Math.cos(Math.PI / 2)));
        System.out.println("cos 90 градусов: " + Math.floor((Math.cos(Math.toRadians(90)))));

        /* Генератор псевдослучайных чисел. */
        System.out.println("\nПсевдослучайное число в диапазоне от 1000 до 9999: " + (int) (Math.random() * 8999 + 1000));
    }
}

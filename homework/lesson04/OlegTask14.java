/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 1.4*. (Тема: Циклы, массивы)
 * Умножать число long a = 1; на 3 пока не произойдёт переполнение.
 * В конце в консоль вывести сообщение со значением до переполнения и после переполнения.
 */
package lesson04;

public class OlegTask14 {
    public static void main(String[] args) {
        long num = 1L;
        double d = num;

        while (d < Long.MAX_VALUE){
            num *= 3;
            d = num*3.0;
        }
        long overNum = num * 3;

        System.out.printf("%nМаксимальное значение Long: %,d", Long.MAX_VALUE);
        System.out.printf("%nЧисло до переполнения:      %,d", num);
        System.out.printf("%nЧисло после переполнения:  %,d%n", overNum);

        // Вывод в консоль:
        // Максимальное значение Long: 9 223 372 036 854 775 807
        // Число до переполнения:      4 052 555 153 018 976 267
        // Число после переполнения:  -6 289 078 614 652 622 815
    }
}
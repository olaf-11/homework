/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 5.1. (Тема: операторы)
 * Операторы ветвления.
 * Используя класс Scanner запросить у пользователя его имя.
 * В данном задании у вас должно получиться 3 класса.
 *
 * Общее условие:
 * 1. Если имя будет равно имени Вася тогда в консоль должно вывести сообщение "Привет!" на одной строке,
 *    а на второй "Я тебя так долго ждал".
 * 2. Если имя будет равно имени "Анастасия" тогда в консоль должно вывести сообщение
 *    "Я тебя так долго ждал".
 * 3. В случае если это будет другое имя то вывести сообщение "Добрый день, а вы кто?".
 *
 * Как это сделать:
 * 5.1. Написать в отдельном классе в отдельном main код который будет выполнять общее условие
 *      при помощи if
 *
 * ВНИМАНИЕ! В примерах if и else if для сравнения имён использовать код вида
 *           Objects.equals("Имя1", "Имя2").
 */
package homework01;

import java.util.Objects;
import java.util.Scanner;

public class OlegTask5_1 {

    /* Оператор ветвления if - else */
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String someName = scanIn.nextLine();
        scanIn.close();

        String bestFriend = "вася";
        String girlFriend = "анастасия";

        boolean checkedBestFriend = Objects.equals(someName.toLowerCase(), bestFriend);
        boolean checkedGirlFriend = Objects.equals(someName.toLowerCase(), girlFriend);

        if (checkedBestFriend){
            System.out.println("Привет!");
        }
        if (checkedBestFriend || checkedGirlFriend){
            System.out.println("Я тебя так долго ждал.");
        }
        if (!(checkedBestFriend || checkedGirlFriend)) {
            System.out.println("Добрый день, а вы кто?");
        }
    }
}

/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 5.3. (Тема: операторы)
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
 * 5.3. Написать в отдельном классе в отдельном main код который будет выполнять общее условие
 *      при помощи switch - case
 */
package homework01;

import java.io.*;

public class OlegTask5_3 {

    /**
     * Оператор ветвления switch - case
     *
     * Вместо Scanner я использую входной символьный поток (в оболочке BufferedReader,
     * чтобы использовать метод readLine() для считывания строк. Так же это избавляет
     * от слежения за закрытием потока [scannerIn.close()].
     *
     * Исключение IOException проверяемое, поэтому использую throws,
     * чтобы убрать из кода конструкцию try-catch. На данном этапе это не принципиально.
     *
     * Метод toLowerCase() позволяет сравнить строки игнорируя регистр букв.
     */
    public static void main(String[] args) throws IOException {
        System.out.print("Введите ваше имя: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        switch (name.toLowerCase()){
            case "вася":
                System.out.println("Привет!");
            case "анастасия":
                System.out.println("Я тебя так долго ждал.");
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
                break;
        }
    }
}
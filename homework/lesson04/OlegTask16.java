/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Альтернативное задание 1.2. (Тема: Циклы, массивы)
 * Все цифры из числа введенного через КОНСОЛЬ
 * перемножить между собой и вывести ход вычислений в консоль.
 * Пример: Ввели 181232375, должно получиться в консоли:
 * 1 * 8 * 1 * 2 * …. * 5 = ответ
 */
package lesson04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OlegTask16 {
    public static void main(String[] args) throws IOException {
        String lineOfNumbers;

        /*
         * В цикле ожидаем ввода цифр, пока юзер не введет
         * набор чисел, удовлетворяющих условиям.
         */
        do{
            System.out.println("Введите набор цифр. ");
            System.out.println("(вводить только цифры, кроме нуля, без пробелов и др. знаков или букв!): ");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            lineOfNumbers = br.readLine();
        } while(!isValidNumbers(lineOfNumbers));

        // Переменная для перевода из char в int
        int num = Integer.parseInt("" + lineOfNumbers.charAt(0));
        System.out.print("\n" + num);

        // Если было введено более 1 цифры
        if(lineOfNumbers.length() != 1) {
            long multiplication = num; // произвдение инициализируем первой цифрой

            // В цикле умножаем цифру и сразу печатаем ее в консоль
            for (int i = 1; i < lineOfNumbers.length(); i++) {
                num = Integer.parseInt("" + lineOfNumbers.charAt(i));
                multiplication *= num;
                System.out.print(" * " + num);
            }
            System.out.println(" = " + multiplication);

            //
            // Для числа 181232375 вывод в консоль следующий:
            // 1 * 8 * 1 * 2 * 3 * 2 * 3 * 7 * 5 = 10080
            //
        } else { // если была введена всего одна цифра
            System.out.println(" = " + num);
        }
    }

    /**
     * Метод проверяет является ли строка положительным целым числом и не нулём.
     * @param str — проверяемая строка
     * @return true если все символы в строке будут только цифрами (1..9) и не ноль.
     */
    public static boolean isValidNumbers(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))||(Integer.parseInt("" + str.charAt(i)) == 0)) {
                return false;
            }
        }

        return true;
    }
}
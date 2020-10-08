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
package homework02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OlegTask13 {
    public static void main(String[] args) throws IOException, ParseException {
        double base = 0.0;
        int power = -1;
        double multi = 1.0;

        System.out.println("Вычислим степень числа.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Введите основание (любое вещественное число, не ноль): ");
            String strNum = br.readLine();

            Pattern pattern = Pattern.compile("(-?\\d+(,|\\.)\\d+)|(-?[0-9]+)");
            Matcher mathch = pattern.matcher(strNum);

            //DecimalFormat df = new DecimalFormat();
            //System.out.println("DecimalSeparator is " + df.getDecimalFormatSymbols().getDecimalSeparator());
            // Вывод в консоль ---> DecimalSeparator is ,

            /*
             * Проверяем, что строка содержит вещественное число.
             * Если пользователь ввел запятую вместо точки, то меняем на точку.
             * Замену делаю при помощи методов StringBuilder.
             */
            if (strNum.indexOf(',') > 0){
                DecimalFormatSymbols decFormatSymb = new DecimalFormatSymbols();
                decFormatSymb.setDecimalSeparator(',');
                DecimalFormat format = new DecimalFormat();
                format.setDecimalFormatSymbols(decFormatSymb);
                base = format.parse(strNum).doubleValue();
            } else {
                base = Double.parseDouble(strNum);
            }

            if (base != 0.0) {
                break;
            } else {
                System.out.println("Строка не является вещественным числом. " +
                        "\nПопробуйте снова, например 2.5");
            }
        }

        while (true) {
            System.out.println("\nВведите степень числа (положительное целое число): ");
            String strNum = br.readLine();

            Pattern pattern = Pattern.compile("([0-9]+)");
            Matcher mathch = pattern.matcher(strNum);

            // Если строка содержит положительное целое число.
            if (mathch.matches()) {
                power = Integer.parseInt(strNum);
            }

            if (power >= 0) {
                break;
            } else {
                System.out.println("Строка не является положительным целым числом. " +
                            "\nПопробуйте снова, например 3");
            }
        }

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

        System.out.println( base + " в степени " + power + " = " + multi);
    }
}

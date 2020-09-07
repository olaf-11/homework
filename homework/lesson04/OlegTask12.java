/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 1.2. (Тема: Циклы, массивы)
 * Все цифры из числа введенного через аргумент к исполняемой программе
 * перемножить между собой и вывести ход вычислений в консоль.
 * Пример: Ввели 181232375, должно получиться в консоли:
 * 1 * 8 * 1 * 2 * …. * 5 = ответ
 */
package lesson04;

public class OlegTask12 {
    public static void main(String[] args) {
        // Проверяю что массив аргуменотов не null,
        // всего аргументов: 1,
        // значение аргумента является числом и нет нулей (дополнительный метод)
        if (args != null && args.length == 1 && isValidNumbers(args[0])){

            // Переменная для перевода из char и int
            int num = Integer.parseInt("" + args[0].charAt(0));
            System.out.print("\n" + num);

            // Если было введено более 1 цифры
            if(args[0].length() != 1){
                long multiplication = num; // произвдение инициализируем первой цифрой

                // В цикле умножаем цифру и сразу печатаем ее в консоль
                for (int i = 1; i < args[0].length(); i++) {
                    num = Integer.parseInt("" + args[0].charAt(i));
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
        } else {
            System.out.println("Вводите набор цифр из диапазона [1..9] (кроме нуля)."
                    + "\nНЕЛЬЗЯ использовать любые другие символы (буквы, знаки, пробелы и т.п.).");
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
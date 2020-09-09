/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 1.1. (Тема: Циклы, массивы)
 * Перемножить числа от 1 до числа (включительно) введенного через аргумент к исполняемой программе.
 * Пример: Ввели 5, должно получиться 1 * 2 * 3 * 4 * 5 = ответ
 */
package lesson04;

public class OlegTask11 {
    public static void main(String[] args) {
        /*
         * Проверяю что массив аргументов не null,
         * всего аргументов: 1,
         * значение аргумента является целым положительным числом (дополнительный метод):
         */
        if (args != null && args.length == 1 && isNumberPositiveInt(args[0])){
            int maxNumber = Integer.parseInt(args[0]);

            /*
             * Проверяю, чтобы число было в диапазоне 2..20,
             * иначе результат может выйти за границу Long.MAX_VALUE
             */
            if(maxNumber > 1 && maxNumber < 21){
                long factorial = 1L;

                System.out.print("\n1");
                for (int i = 2; i <= maxNumber; i++){
                    factorial *= i;
                    System.out.print(" * " + i);
                }
                System.out.printf(" = %,d%n", factorial);
            } else {
                System.out.println("Целое число должно быть из диапазона [2..20] включительно:");
            }
        } else {
            System.out.println("Вводите любое целое число из диапазона [2..20] включительно:");
        }
    }

    /**
     * Метод проверяет является ли строка положительным целым числом.
     * @param str — проверяемая строка
     * @return true если все символы в строке будут только цифрами (0..9).
     */
    public static boolean isNumberPositiveInt(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 1.5. (Тема: Циклы, массивы)
 * Вывести таблицу умножения в консоль.
 * В консоли должно получиться также как и на картинке (динозаврика рисовать не надо):
 * https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0
 */
package homework02;

public class OlegTask15 {
    public static void main(String[] args) {
        int multiplierMin = 1; // Множитель с которого начинать умножение числа
        int multiplierMax = 10; // Множитель которым заканчивать умножение числа
        int NumMin = 2; // Минимальное число с которого начинать таблицу
        int NumMax = 9; // Максимальное число до которого делать таблицу
        int columnsMax = 4; // Сколько колонок (столбиков) таблиц распечатывать в одном ряду

        // Символ умножения окруженный пробелами (multiplicationSign): " × "
        String mSign = " " + (char) 0x00D7 + " ";

        /*
         * Рассчитваю сколько всего будет строк таблиц в зависимости того,
         * сколько будет всего таблиц с числами (NumMax - NumMin + 1),
         * в зависимости от columnsMax столбиков в одной такой строке.
         */
        int RowsMax = (NumMax - NumMin + 1) / columnsMax;
        if ((NumMax - NumMin + 1) % columnsMax > 0) {
            RowsMax++;
        }

        // Цикл глобальных строк (столбики таблиц)
        for (int row = 0; row < RowsMax; row++) {
            // Цикл множителей
            for (int j = multiplierMin; j <= multiplierMax; j++) {
                // Цикл одной строки в таблице
                for (int i = NumMin + row * columnsMax;
                        (i < NumMin + row * columnsMax + columnsMax) && (i <= NumMax); i++) {
                    System.out.printf("%2d%s%2d%s%2d%2s", i, mSign, j, " = ", i * j, "");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
/*
 * 1. Написать метод String toString(int number).
 *    1.1 В данном методе произвести конвертацию переданного числа в число прописью.
 *        Числа от - 999 999 999 до 999 999 999
 *    1.2 Пример передали: 223. Получили "Двести двадцать три"
 *
 * 2. Написать метод String toString(double number).
 *    2.1 В данном методе произвести конвертацию переданного числа в число прописью.
 *        Выводить до сотых, без округления.
 *    2.2 Пример передали: 223.1599999. Получили "Двести двадцать три целых пятнадцать сотых".
 *
 * 3. Написать метод String toWeek(int day).
 *    3.1 В данном методе посчитать количество прошедших недель по переданному числу дней.
 *    3.2 Пример передали: 5. Получили "0 недель"
 *    3.3 Пример передали: 14. Получили "2 недели"
 *    3.4 Пример передали: 177. Получили "25 недель"
 */
package lesson08_var2;

public class TestNumbersGroup {
    public static void main(String[] args) {
        //NumbersGroup ngr;
        //for (int i = 0; i < 100; i++) {
        //    ngr = new NumbersGroup(i, 0, 0);
        //    if(i % 10 == 0) System.out.println();
        //    System.out.println(ngr.spellIt());
        //}
        //NumbersGroup ngr = new NumbersGroup(101, 1, 1);
        //System.out.println(ngr.spellIt());
        System.out.println();
        System.out.println(toString(-701000102102L));

        System.out.println();
        System.out.println(toString(-654654041.915623));
        //System.out.println(toString(-2L, 0));
        //for (int i = 0; i < 7; i++) {
        //    System.out.println((long) Math.pow(1000, i));
        //}

    }

    // Метод для перевода целого числа в его текстовую форму
    public static String toString(long number){
        //
        if (number != 0) {
            return NumberToString(number, 0);
        } else {
            return "ноль";
        }
    }

    // Метод для перевода дробного числа в его текстовую форму
    public static String toString(double number){
        Double num = number;
        long lPart = num.longValue();// Целая часть числа
        num = (number - lPart) * 100;
        long fPart = num.longValue();// Дробная часть числа (сотые)
        if (fPart < 0) fPart = -fPart;

        if (lPart == 0 && fPart == 0) {
            return "ноль";
        }

        int twoLastRanks = lPart < 0 ? (int) (-lPart % 100) : (int) (lPart % 100);

        if (lPart == 0){
            return "ноль целых " +
                   NumberToString(fPart, 1) + spellSpecWords((int) fPart,1);
        }
        if (fPart == 0) {
            return NumberToString(lPart, 1) + spellSpecWords(twoLastRanks,0) +
                   "ноль сотых.";
        }
        return NumberToString(lPart, 1) + spellSpecWords(twoLastRanks,0) +
               NumberToString(fPart, 1) + spellSpecWords((int) fPart,1);
    }

    // Метод для перевода числа в номер недели.
    public String toWeek(int day){
        int week = day / 7;

        String str = "" + week;

        if (!((week > 10) && (week < 15))){
            if (week % 10 == 1){
                return str += " неделя";
            } else if (week % 10 > 1 && week % 10 < 5){
                return str += " недели";
            }
        }
        return str += " недель";
    }

    // Основной метод для перевода чисел в их текстовую форму
    private static String NumberToString (long lNumber, int genus){
        if (Math.abs(lNumber) > 1_000_000_000_000L) {
            return "\nЧисло выходит за границы допустимого диапазона.\n" +
                    "Попробуйте снова с числом из диапазона\n" +
                    "(-1 000 000 000 000 .. 1 000 000 000)\n";
        }
        StringBuilder str = new StringBuilder();
        if (lNumber < 0) {
            lNumber = - lNumber;
            str = str.append("минус ");
        }

        // Подсчитываю количество классов числа (единицы, сотни, тысячи и т.д.) по 3 разряда в каждом
        String sNumber = ("" + lNumber);
        int index = sNumber.length() % 3 == 0 ? sNumber.length() / 3 : sNumber.length() / 3 + 1;

        // Определяю все классы числа по отдельным группам (с использованием спец. класса)
        NumbersGroup[] numGrp = new NumbersGroup[index];
        for (int i = 0; i < index; i++) {
            int n = (int) ((lNumber % (1000 * Math.pow(1000, i))) / Math.pow(1000, i));
            if (i == 0) {
                numGrp[i] = new NumbersGroup(n, i, genus);
            } else if (i == 1) {
                numGrp[i] = new NumbersGroup(n, i, 1);
            } else {
                numGrp[i] = new NumbersGroup(n, i, 0);
            }
        }
        // Формируем строку всего числа
        for (int i = numGrp.length - 1; i >= 0; i--) {
            String test = numGrp[i].spellIt();
            if (!test.equals("")) {
                str.append(test + " ");
            }
        }
        return str.toString();
    }

    // Метод возвращает строку с названием целой или дробной части в зависимости от окончания
    private static String spellSpecWords(int nPart, int nIndex){
        final String[][] specWords = {{"целая ", "целыe ", "целых "},
                                      {"сотая.", "сотые.", "сотых."}};
        if (nPart % 10 == 1 && nPart != 11) {
            return specWords[nIndex][0];
        }
        if (!(nPart > 11 && nPart < 15) && nPart % 10 > 1 && nPart % 10 < 5) {
            return specWords[nIndex][1];
        }
        return specWords[nIndex][2];
    }
}

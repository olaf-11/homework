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
package lesson08;

class SpellingNumbers {
    final String[] firstTwenties = {"", "один", "два", "три", "четыре", "пять", "шесть",
                                    "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать",
                                    "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                                    "семнадцать", "восемнадцать", "девятнадцать"};
    final String[] dozens = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят",
                             "семьдесят", "восемьдесят", "девяносто"};
    final String[] hundreds = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот",
                               "семьсот", "восемьсот", "девятьсот"};
    final String[][] ranks = {{" тысяча", " тысячи", " тысяч"},
                              {" миллион", " миллиона", " миллионов"},
                              {" миллиард", " миллиарда", " миллиардов"}};

    final String[] thousSuffix = {"", "одна", "две"};// меняются окончания в цифрах у тысяч.

    public String toString(long number){
        if (number == 0) return "ноль";
        if (number > 999) {
            return spellBigNumbers(number);
        }
        return spellHundreds(number, false);
    }

    public String toString(double number){
        Double num = number;
        long lPart = num.longValue();// Целая часть числа
        num = (number - lPart) * 100;
        long fPart = num.longValue();// Дробная часть числа (сотые)

        return toString(lPart) + " целых " + toString(fPart) + " сотых.";
    }

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

    // Дополнительные методы:
    //
     private String spellHundreds(long num, boolean isThousands){
        // до тысячи
        if (num < 20) {
            if (isThousands && num % 100 != 11 && num % 100 != 12 && ((num % 100) % 10 == 1 || (num % 100) % 10 == 2)) {
                return thousSuffix[(int) (num % 100) % 10];
            }
            return firstTwenties[(int) num];
        }
        if (num < 100){
            if (isThousands && ((num % 100) % 10 == 1 || (num % 100) % 10 == 2)) {
                return dozens[(int) num / 10] + " " + thousSuffix[(int) (num % 100) % 10];
            }
            return dozens[(int) num / 10] + " " + firstTwenties[(int) num % 10];
        }
        if (num < 1000) {
            if (isThousands){
                return hundreds[(int) num / 100] + " " + spellHundreds(num % 100, true);
            }
            return hundreds[(int) num / 100] + " " + spellHundreds(num % 100, false);
        }
        return "ничего";
    }

    private String spellBigNumbers(long num){
        // тысячи
        if (num < 1000000) {
            long remDec = (num / 1000) % 100;
            long rem = remDec % 10;

            if (remDec != 11 && rem == 1) {
                return spellHundreds(num / 1000, true) +
                       ranks[0][0] + " " + spellHundreds(num % 1000, false);
            } else if (!(remDec > 10 && remDec < 16) && rem > 1 && rem < 5) {
                return spellHundreds(num / 1000, true) +
                       ranks[0][1] + " " + spellHundreds(num % 1000, false);
            } else {
                return spellHundreds(num / 1000, true) +
                       ranks[0][2] + " " + spellHundreds(num % 1000, false);
            }
        }
        // миллионы
        if (num < 1000_000_000) {
            long remDec = (num / 1000000) % 100;
            long rem = remDec % 10;

            if (remDec != 11 && rem == 1) {
                return spellHundreds(num / 1000000, false) +
                        ranks[1][0] + " " + spellBigNumbers(num % 1000000);
            } else if (!(remDec > 10 && remDec < 16) && rem > 1 && rem < 5) {
                return spellHundreds(num / 1000000, false) +
                        ranks[1][1] + " " + spellBigNumbers(num % 1000000);
            } else {
                return spellHundreds(num / 1000000, false) +
                        ranks[1][2] + " " + spellBigNumbers(num % 1000000);
            }
        }
        // миллиарды
        if (num < 1000_000_000_000L) {
            long remDec = (num / 1000_000_000) % 100;
            long rem = remDec % 10;

            if (remDec != 11 && rem == 1) {
                return spellHundreds(num / 1000_000_000, false) +
                        ranks[2][0] + " " + spellBigNumbers(num % 1000_000_000);
            } else if (!(remDec > 10 && remDec < 16) && rem > 1 && rem < 5) {
                return spellHundreds(num / 1000_000_000, false) +
                        ranks[2][1] + " " + spellBigNumbers(num % 1000_000_000);
            } else {
                return spellHundreds(num / 1000_000_000, false) +
                        ranks[2][2] + " " + spellBigNumbers(num % 1000_000_000);
            }
        }
        return "ничего";
    }
}
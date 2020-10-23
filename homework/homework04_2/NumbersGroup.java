/**
 * Класс который содержит отдельный класс числа (сотни, тысячи, млн, млрд и т.д.),
 * состоящий из группы до 3-х цифр.
 * В константах определён их произоншение (написание) в формате слов.
 *
 * @number -- трехзначное (или меньше знаков) положительное число.
 * @rank   -- класс числа (т.е. сотни, тысячи, млн, млрд и т.д.).
 * @genus  -- в каком роде возвращать слова (муж., жен., ср.).
 */
package homework04_2;

public class NumbersGroup {
    public static final String[][] TWO = {{"", "один", "два"},
                                          {"", "одна", "две"},
                                          {"", "одно", "два"}};

    public static final String[] TWENTY = {
            "", "", "", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
            };

    public static final String[] DOZENS = {
            "", "", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
            };

    public static final String[] HUNDREDS = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"
            };

    public static String[][] RANKS = {{"", "", ""},
                                      {" тысяча", " тысячи", " тысяч"},
                                      {" миллион", " миллиона", " миллионов"},
                                      {" миллиард", " миллиарда", " миллиардов"}};

    private int number; // положительное число в диапазоне [0 ... 999]
    private int rank; // класс числа ((0)единиц, (1)тысяч, (2)миллионов, (3)миллиардов...)
    public int genus; // род возвращаемого значения: 0 - мужской род
                                                  //  1 - женский род
                                                  //  2 - средний род

    public NumbersGroup(int numForSpell, int rankOfNum, int genusOfSpelling) {
        number = numForSpell;
        rank = rankOfNum;
        genus = genusOfSpelling;
    }

    public String spellIt(){
        return speller(number);
    }

    private String speller(int i){
        if (i == 0) {
            return "";
        }
        if (i < 3) {
            return TWO[genus][i] + RANKS[rank][i - 1];
        }
        if (i < 5) {
            return TWENTY[i] + RANKS[rank][1];
        }
        if (i < 20) {
            return TWENTY[i] + RANKS[rank][2];
        }
        if (i < 100) {
            if (i % 10 != 0) {
                return DOZENS[i / 10] + " " + speller(i % 10);
            } else {
                return DOZENS[i / 10] + speller(0);
            }
        }
        if (i < 1000) {
            if (i % 100 != 0) {
                return HUNDREDS[i / 100] + " " + speller(i % 100);
            } else {
                return HUNDREDS[i / 100] + speller(0);
            }
        }
        return "";
    }
}

/*
 * 1. �������� ����� String toString(int number).
 *    1.1 � ������ ������ ���������� ����������� ����������� ����� � ����� ��������.
 *        ����� �� - 999 999 999 �� 999 999 999
 *    1.2 ������ ��������: 223. �������� "������ �������� ���"
 *
 * 2. �������� ����� String toString(double number).
 *    2.1 � ������ ������ ���������� ����������� ����������� ����� � ����� ��������.
 *        �������� �� �����, ��� ����������.
 *    2.2 ������ ��������: 223.1599999. �������� "������ �������� ��� ����� ���������� �����".
 *
 * 3. �������� ����� String toWeek(int day).
 *    3.1 � ������ ������ ��������� ���������� ��������� ������ �� ����������� ����� ����.
 *    3.2 ������ ��������: 5. �������� "0 ������"
 *    3.3 ������ ��������: 14. �������� "2 ������"
 *    3.4 ������ ��������: 177. �������� "25 ������"
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

    // ����� ��� �������� ������ ����� � ��� ��������� �����
    public static String toString(long number){
        //
        if (number != 0) {
            return NumberToString(number, 0);
        } else {
            return "����";
        }
    }

    // ����� ��� �������� �������� ����� � ��� ��������� �����
    public static String toString(double number){
        Double num = number;
        long lPart = num.longValue();// ����� ����� �����
        num = (number - lPart) * 100;
        long fPart = num.longValue();// ������� ����� ����� (�����)
        if (fPart < 0) fPart = -fPart;

        if (lPart == 0 && fPart == 0) {
            return "����";
        }

        int twoLastRanks = lPart < 0 ? (int) (-lPart % 100) : (int) (lPart % 100);

        if (lPart == 0){
            return "���� ����� " +
                   NumberToString(fPart, 1) + spellSpecWords((int) fPart,1);
        }
        if (fPart == 0) {
            return NumberToString(lPart, 1) + spellSpecWords(twoLastRanks,0) +
                   "���� �����.";
        }
        return NumberToString(lPart, 1) + spellSpecWords(twoLastRanks,0) +
               NumberToString(fPart, 1) + spellSpecWords((int) fPart,1);
    }

    // ����� ��� �������� ����� � ����� ������.
    public String toWeek(int day){
        int week = day / 7;

        String str = "" + week;

        if (!((week > 10) && (week < 15))){
            if (week % 10 == 1){
                return str += " ������";
            } else if (week % 10 > 1 && week % 10 < 5){
                return str += " ������";
            }
        }
        return str += " ������";
    }

    // �������� ����� ��� �������� ����� � �� ��������� �����
    private static String NumberToString (long lNumber, int genus){
        if (Math.abs(lNumber) > 1_000_000_000_000L) {
            return "\n����� ������� �� ������� ����������� ���������.\n" +
                    "���������� ����� � ������ �� ���������\n" +
                    "(-1 000 000 000 000 .. 1 000 000 000)\n";
        }
        StringBuilder str = new StringBuilder();
        if (lNumber < 0) {
            lNumber = - lNumber;
            str = str.append("����� ");
        }

        // ����������� ���������� ������� ����� (�������, �����, ������ � �.�.) �� 3 ������� � ������
        String sNumber = ("" + lNumber);
        int index = sNumber.length() % 3 == 0 ? sNumber.length() / 3 : sNumber.length() / 3 + 1;

        // ��������� ��� ������ ����� �� ��������� ������� (� �������������� ����. ������)
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
        // ��������� ������ ����� �����
        for (int i = numGrp.length - 1; i >= 0; i--) {
            String test = numGrp[i].spellIt();
            if (!test.equals("")) {
                str.append(test + " ");
            }
        }
        return str.toString();
    }

    // ����� ���������� ������ � ��������� ����� ��� ������� ����� � ����������� �� ���������
    private static String spellSpecWords(int nPart, int nIndex){
        final String[][] specWords = {{"����� ", "����e ", "����� "},
                                      {"�����.", "�����.", "�����."}};
        if (nPart % 10 == 1 && nPart != 11) {
            return specWords[nIndex][0];
        }
        if (!(nPart > 11 && nPart < 15) && nPart % 10 > 1 && nPart % 10 < 5) {
            return specWords[nIndex][1];
        }
        return specWords[nIndex][2];
    }
}

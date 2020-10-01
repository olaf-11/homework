/**
 * ����� ������� �������� ��������� ����� ����� (�����, ������, ���, ���� � �.�.),
 * ��������� �� ������ �� 3-� ����.
 * � ���������� �������� �� ������������ (���������) � ������� ����.
 *
 * @number -- ����������� (��� ������ ������) ������������� �����.
 * @rank   -- ����� ����� (�.�. �����, ������, ���, ���� � �.�.).
 * @genus  -- � ����� ���� ���������� ����� (���., ���., ��.).
 */
package lesson08_var2;

public class NumbersGroup {
    public static final String[][] TWO = {{"", "����", "���"},
                                          {"", "����", "���"},
                                          {"", "����", "���"}};

    public static final String[] TWENTY = {
            "", "", "", "���", "������", "����", "�����", "����", "������", "������",
            "������", "�����������", "����������", "����������", "������������", "����������",
            "�����������", "����������", "������������", "������������"
            };

    public static final String[] DOZENS = {
            "", "", "��������", "��������", "�����", "���������",
            "����������", "���������", "�����������", "���������"
            };

    public static final String[] HUNDREDS = {
            "", "���", "������", "������", "���������", "�������",
            "��������", "�������", "���������", "���������"
            };

    public static String[][] RANKS = {{"", "", ""},
                                      {" ������", " ������", " �����"},
                                      {" �������", " ��������", " ���������"},
                                      {" ��������", " ���������", " ����������"}};

    private int number; // ������������� ����� � ��������� [0 ... 999]
    private int rank; // ����� ����� ((0)������, (1)�����, (2)���������, (3)����������...)
    public int genus; // ��� ������������� ��������: 0 - ������� ���
                                                  //  1 - ������� ���
                                                  //  2 - ������� ���

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

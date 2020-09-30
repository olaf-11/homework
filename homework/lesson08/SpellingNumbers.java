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
package lesson08;

class SpellingNumbers {
    final String[] firstTwenties = {"", "����", "���", "���", "������", "����", "�����",
                                    "����", "������", "������", "������", "�����������", "����������",
                                    "����������", "������������", "����������", "�����������",
                                    "����������", "������������", "������������"};
    final String[] dozens = {"", "", "��������", "��������", "�����", "���������", "����������",
                             "���������", "�����������", "���������"};
    final String[] hundreds = {"", "���", "������", "������", "���������", "�������", "��������",
                               "�������", "���������", "���������"};
    final String[][] ranks = {{" ������", " ������", " �����"},
                              {" �������", " ��������", " ���������"},
                              {" ��������", " ���������", " ����������"}};

    final String[] thousSuffix = {"", "����", "���"};// �������� ��������� � ������ � �����.

    public String toString(long number){
        if (number == 0) return "����";
        if (number > 999) {
            return spellBigNumbers(number);
        }
        return spellHundreds(number, false);
    }

    public String toString(double number){
        Double num = number;
        long lPart = num.longValue();// ����� ����� �����
        num = (number - lPart) * 100;
        long fPart = num.longValue();// ������� ����� ����� (�����)

        return toString(lPart) + " ����� " + toString(fPart) + " �����.";
    }

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

    // �������������� ������:
    //
     private String spellHundreds(long num, boolean isThousands){
        // �� ������
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
        return "������";
    }

    private String spellBigNumbers(long num){
        // ������
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
        // ��������
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
        // ���������
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
        return "������";
    }
}
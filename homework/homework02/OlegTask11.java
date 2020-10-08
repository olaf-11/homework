/*
 * ���� ���������� (������ MK-JC1-50-20)
 * �. �����, 2020
 *
 * ������� 1.1. (����: �����, �������)
 * ����������� ����� �� 1 �� ����� (������������) ���������� ����� �������� � ����������� ���������.
 * ������: ����� 5, ������ ���������� 1 * 2 * 3 * 4 * 5 = �����
 */
package homework02;

public class OlegTask11 {
    public static void main(String[] args) {
        /*
         * �������� ��� ������ ���������� �� null,
         * ����� ����������: 1,
         * �������� ��������� �������� ����� ������������� ������ (�������������� �����):
         */
        if (args != null && args.length == 1 && isNumberPositiveInt(args[0])){
            int maxNumber = Integer.parseInt(args[0]);

            /*
             * ��������, ����� ����� ���� � ��������� 2..20,
             * ����� ��������� ����� ����� �� ������� Long.MAX_VALUE
             */
            if(maxNumber > 1 && maxNumber < 21){
                long factorial = 1L;

                System.out.print("\n1");
                for (int i = 2; i <= maxNumber; i++){
                    factorial *= i;
                    System.out.print(" * " + i);
                }
                System.out.printf(" = %,d%n", factorial);
            }
        } else {
            System.out.println("������� ����� ����� ����� �� ��������� [2..20] ������������");
        }
    }

    /**
     * ����� ��������� �������� �� ������ ������������� ����� ������.
     * @param str � ����������� ������
     * @return true ���� ��� ������� � ������ ����� ������ ������� (0..9).
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

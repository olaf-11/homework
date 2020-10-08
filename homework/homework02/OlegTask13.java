/*
 * ���� ���������� (������ MK-JC1-50-20)
 * �. �����, 2020
 *
 * ������� 1.3. (����: �����, �������)
 * ���������� � �������.
 * ����� ������� ������������ ������ ��� �����.
 * ������ ����� ��� ����� ������� �� ����� ���������, ����� ���� ������������� � �������.
 * ������ ����� ��� ������� � ������� �������� ������ �����
 * ������� - ������ ������������� � �����.
 */
package homework02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OlegTask13 {
    public static void main(String[] args) throws IOException, ParseException {
        double base = 0.0;
        int power = -1;
        double multi = 1.0;

        System.out.println("�������� ������� �����.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("������� ��������� (����� ������������ �����, �� ����): ");
            String strNum = br.readLine();

            Pattern pattern = Pattern.compile("(-?\\d+(,|\\.)\\d+)|(-?[0-9]+)");
            Matcher mathch = pattern.matcher(strNum);

            //DecimalFormat df = new DecimalFormat();
            //System.out.println("DecimalSeparator is " + df.getDecimalFormatSymbols().getDecimalSeparator());
            // ����� � ������� ---> DecimalSeparator is ,

            /*
             * ���������, ��� ������ �������� ������������ �����.
             * ���� ������������ ���� ������� ������ �����, �� ������ �� �����.
             * ������ ����� ��� ������ ������� StringBuilder.
             */
            if (strNum.indexOf(',') > 0){
                DecimalFormatSymbols decFormatSymb = new DecimalFormatSymbols();
                decFormatSymb.setDecimalSeparator(',');
                DecimalFormat format = new DecimalFormat();
                format.setDecimalFormatSymbols(decFormatSymb);
                base = format.parse(strNum).doubleValue();
            } else {
                base = Double.parseDouble(strNum);
            }

            if (base != 0.0) {
                break;
            } else {
                System.out.println("������ �� �������� ������������ ������. " +
                        "\n���������� �����, �������� 2.5");
            }
        }

        while (true) {
            System.out.println("\n������� ������� ����� (������������� ����� �����): ");
            String strNum = br.readLine();

            Pattern pattern = Pattern.compile("([0-9]+)");
            Matcher mathch = pattern.matcher(strNum);

            // ���� ������ �������� ������������� ����� �����.
            if (mathch.matches()) {
                power = Integer.parseInt(strNum);
            }

            if (power >= 0) {
                break;
            } else {
                System.out.println("������ �� �������� ������������� ����� ������. " +
                            "\n���������� �����, �������� 3");
            }
        }

        switch (power) {
            case 0:
                multi = 1;
                break;
            case 1:
                multi = base;
                break;
            default:
                for (int i = 0; i < power; i++) {
                    multi *= base;
                }
                break;
        }

        System.out.println( base + " � ������� " + power + " = " + multi);
    }
}

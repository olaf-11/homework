/*
 * ���� ���������� (������ MK-JC1-50-20)
 * �. �����, 2020
 *
 * ������� 4.3. (����: �����, �������)
 * ��������� ���������� ������� � �������.
 * ����� ��������� ���������:
 * --> ����������� ����������
 * --> ��������� ����������
 *
 * ����� ������ ���������� � ������� � ��� ������ ����������
 * "[����� ������ ��� �� ����������] -> [����� ���� ������ ����� ����������]".
 * ��� ������ ����� ������������ Arrays.
 *
 * �������� ��� ������� ����� ��������� ������ ������ ����� �������.
 */
package homework02;
import static homework02.OlegTask41.bubbleSort;
import static homework02.OlegTask41.shakerSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OlegTask43 {
    public static void main(String[] args) throws IOException {
        //
        System.out.println("������� ����� ����� �����, ����� ������� � ������." +
                "\n��������, 3, -5, 56, 23, 99456, 0");
        // �������� ����:
        // -5, 789, 0, -24, 18, 62, 38, 624, -224, -67, 45, 107, 204, -851, 253, 77, -914
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(", ");

        int[] bArray = new int [numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            bArray[i] = Integer.parseInt(numbers[i]);
        }

        //

        System.out.println("\n����������� ���������� ----------------------------------------------->");
        System.out.println("\n�������� ������      -> " + Arrays.toString(bArray));
        bubbleSort(bArray);
        System.out.println("������������� ������ -> " + Arrays.toString(bArray));
        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            bArray[i] = Integer.parseInt(numbers[i]);
        }
        //

        System.out.println("��������� ���������� ------------------------------------------------->");
        System.out.println("\n�������� ������      -> " + Arrays.toString(bArray));
        shakerSort(bArray);
        System.out.println("������������� ������ -> " + Arrays.toString(bArray));
        System.out.println();
    }
}
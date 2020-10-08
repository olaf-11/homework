/*
 * ���� ���������� (������ MK-JC1-50-20)
 * �. �����, 2020
 *
 * ������� 4.2. (����: �����, �������)
 * ��������� ���������� ������� � �������.
 * ����� ��������� ���������:
 * --> ����������� ����������
 * --> ��������� ����������
 *
 * ����� ������ ���������� � ������� � ��� ������ ����������
 * "[����� ������ ��� �� ����������] -> [����� ���� ������ ����� ����������]".
 * ��� ������ ����� ������������ Arrays.
 *
 * �������� ��� ������� ����� ��������� ������ ��������� ������,
 * ��������� ������ ���������� �������.
 */
package homework02;
import static homework02.OlegTask41.bubbleSort;
import static homework02.OlegTask41.shakerSort;

import java.util.Arrays;
import java.util.Random;

public class OlegTask42 {
    public static void main(String[] args) {
        //
        Random rnd = new Random();
        int[] bArray = new int[rnd.nextInt(18)];
        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = rnd.nextInt(2000) - 1000;
        }

        System.out.println("\n����������� ���������� ----------------------------------------------->");
        System.out.println("\n�������� ������      -> " + Arrays.toString(bArray));
        bubbleSort(bArray);
        System.out.println("������������� ������ -> " + Arrays.toString(bArray));
        System.out.println();

        bArray = new int[rnd.nextInt(15)];
        for (int i = 0; i < bArray.length; i++) {
            bArray[i] = rnd.nextInt(2000) - 1000;
        }

        System.out.println("��������� ���������� ------------------------------------------------->");
        System.out.println("\n�������� ������      -> " + Arrays.toString(bArray));
        shakerSort(bArray);
        System.out.println("������������� ������ -> " + Arrays.toString(bArray));
        System.out.println();
    }
}
/*
 * ���� ���������� (������ MK-JC1-50-20)
 * �. �����, 2020
 *
 * �������. (����: ���������, �����������, �����������)
 *
 * 1.������ ������ ��� �������� ���������� �� ��������:
 *   1.1. �������� ����� Person ������� �������� ����:
 *        1.1.1. ������ nick - ��������� ������������
 *        1.1.2. ������ password - ������ (�� 5 �� 10 ��������)
 *
 * 2. ������� ����������� ��� ������� ������� ����������:
 *    2.1. ����� ������ �������������
 *    2.2. ����� ������ ������������� � ���������� ������������� �� ��������
 *         (�������� ��������� � ������ 2.99)
 *    2.99. ����������� ������ ���������� � ��� ��� � ��� ������ ���������� ���������� �� ���� �����,
 *          ������� �� �������, ����� �� �������. � �������: ���� ������ ��������
 *          [{age: 10, nick: "��������"}, {age: 10, "�����"}, {age: 1, nick: "�������"}, {age: 10, "����"}].
 *          ����� ���������� ������ ����������: [{{age: 1, nick: "�������"}, age: 10, nick: "��������"},
 *          {age: 10, "�����"}, {age: 10, "����"}]. ��� ��� ������� ����������� �� �������� � ������� �����������,
 *          � ����� � ������ ������ (age = 10), ����������� �� ������ �� ����������� (�� ��������).
 *
 * 3. ������ � �����������. ��������� �������� ��� ������������ ������� ��������� �� ��������� ������� 1:
 *    3.1. ��� ������ ������� ���������� 1_000_000 (���� ��������� ������ ������� 100_000)
 *         ������ �������� ������ ������. ���� ����������� ���������� �������.
 *    3.2. ���������:
 *         3.2.1. LinkedList
 *         3.2.2. ArrayList
 *         3.2.3. HashSet
 *         3.2.4. TreeSet
 *    3.3. ������������� ��������� ��������� ����������� �� ������� 2.
 *         3.3.1. ��������� ����������� ���������� jdk
 *         3.3.2.* ��������� ����������� ������� ����������
 *    3.4. �������� ����� � ����������� �������: "��������: ����. ������ YYYY ��".
 *         ��� ������ ������������ ����� �� jdk System.currentTimeMillis():
 *         3.4.1. ���������� ���������
 *         3.4.2. ������������ ���������:
 *                3.4.2.1. ��� ������ iterator
 *                3.4.2.2. ��� ������ ������ ������� ������� (�� foreach)
 *         3.4.3. �������� ���� ��������� ��������� (������� ���� ��):
 *                3.4.3.1. ��� ������ iterator
 *                3.4.3.2. ��� ������ ������ ������� �������
 */
package homework06;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.*;
import static homework06.Utility.*;

public class TestPersonColl {
    public static void main(String[] args) {
        long[][] timeOperations = new long[4][4];
        PersonComparator pCompar = new PersonComparator();

        // 3.2. ��������� ���������
        // 3.4.1. �������� ����� ���������� ���������

        //      3.2.1. LinkedList
        List<Person> pLinkList = new LinkedList<>();
        long startTimer = System.currentTimeMillis();
        generatePersonCollection(pLinkList);
        long stopTimer = System.currentTimeMillis();
        timeOperations[0][0] = stopTimer - startTimer;

        //      3.2.2. ArrayList
        List<Person> pArrList = new ArrayList<>();
        startTimer = System.currentTimeMillis();
        generatePersonCollection(pArrList);
        stopTimer = System.currentTimeMillis();
        timeOperations[1][0] = stopTimer - startTimer;

        //      3.2.3. HashSet
        Set<Person> pHashSet = new HashSet<>();
        startTimer = System.currentTimeMillis();
        generatePersonCollection(pHashSet);
        stopTimer = System.currentTimeMillis();
        timeOperations[2][0] = stopTimer - startTimer;

        //      3.2.4. TreeSet
        Set<Person> pTreeSet = new TreeSet<>(pCompar);
        startTimer = System.currentTimeMillis();
        generatePersonCollection(pTreeSet);
        stopTimer = System.currentTimeMillis();
        timeOperations[3][0] = stopTimer - startTimer;

        // 3.3. ������������� ��������� ��������� �����������.
        //      3.3.1. ��������� ����������� ���������� jdk
        Collections.sort(pLinkList, pCompar);
        Collections.sort(pArrList, pCompar);
        List<Person> pList = new ArrayList<>(pHashSet);
        Collections.sort(pList, pCompar);
        // ��������� TreeSet ������ ��������������.

        //      3.3.2.* ��������� ����������� ������� ���������� (��� ��� ����������� �����������...)
        //sort(pLinkList, pCompar);
        //sort(pArrList, pCompar);
        //List<Person> pList = new ArrayList<>(pHashSet);
        //sort(pList, pCompar);

        // 3.4.2. �������� ����� ������������ ���������
        //        3.4.2.1. ��� ������ iterator
        timeOperations[0][1] = iterateCollection(pLinkList);
        timeOperations[1][1] = iterateCollection(pArrList);
        timeOperations[2][1] = iterateCollection(pHashSet);
        timeOperations[3][1] = iterateCollection(pTreeSet);

        // 3.4.2. �������� ����� ������������ ���������
        //        3.4.2.2. ��� ������ ������ ������� ������� (�� foreach)
        timeOperations[0][2] = iterateWithNoIterList(pLinkList);
        timeOperations[1][2] = iterateWithNoIterList(pArrList);
        timeOperations[2][2] = iterateWithNoIterSet(pHashSet);
        timeOperations[3][2] = iterateWithNoIterSet(pTreeSet);

        // 3.4.3. �������� ���� ��������� ��������� (������� ���� ��):
        //        3.4.3.1. ��� ������ iterator
        //        3.4.3.2. ��� ������ ������ ������� �������

        startTimer = System.currentTimeMillis();
        Iterator<Person> iter = pLinkList.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        stopTimer = System.currentTimeMillis();
        timeOperations[0][3] = stopTimer - startTimer;

        startTimer = System.currentTimeMillis();
        for (int i = pArrList.size() - 1; i >= 0 ; i--) {
            pArrList.remove(i);
        }
        stopTimer = System.currentTimeMillis();
        timeOperations[1][3] = stopTimer - startTimer;

        startTimer = System.currentTimeMillis();
        Object[] tmp = pHashSet.toArray();
        int k = 0;
        while (pHashSet.size() > 0) {
            if (pHashSet.contains(tmp[k])) {
                pHashSet.remove(tmp[k]);
                k++;
            }
        }
        stopTimer = System.currentTimeMillis();
        timeOperations[2][3] = stopTimer - startTimer;
        tmp = null;

        startTimer = System.currentTimeMillis();
        iter = pTreeSet.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        stopTimer = System.currentTimeMillis();
        timeOperations[3][3] = stopTimer - startTimer;

        String[] collectionName = {"LinkedList", "ArrayList", "HashSet", "TreeSet"};
        System.out.printf("\n%11s | %11s | %11s | %11s | %15s ",
                          "���", "�����", "�������", "�������", "��������");
        System.out.printf("\n%11s | %11s | %11s | %11s | %15s ",
                          "���������", "��������", "� Iterator", "�� Iterator", "���� ���������");
        System.out.print("\n----------- | ----------- | ----------- | ----------- | --------------- ");
        for (int i = 0; i < collectionName.length; i++) {
            System.out.printf("\n%-11s | %11d | %11d | %11d | %15d ", collectionName[i],
                              timeOperations[i][0], timeOperations[i][1],
                              timeOperations[i][2], timeOperations[i][3]);
        }
        System.out.println();
        System.out.println("\n   *����� � �������������.");
        System.out.println();
    }

    private static Collection<Person> generatePersonCollection(Collection<Person> per){
        String filePath = "homework/homework/homework06/names.txt";
        if(Files.exists(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS)){
            String str = readAllBytesJava7(filePath);
            String[] arrStr = str.split(", ");
            Random rnd = new Random();

            for (int i = 0; i < 150_000; i++) {
                per.add(new Person(arrStr[rnd.nextInt(arrStr.length)] + "_" +  i, RandomPwd.nextPwd()));
            }
            return per;
        }
        return null;
    }

    private static void printCollPer(Collection<Person> pers){
        System.out.println("\n-----------------------------------------------");
        for (Person one: pers) {
            System.out.printf("%-25s : %s\n", one.getNick(), one.getPassword());
        }
        System.out.println("-----------------------------------------------");
    }
}

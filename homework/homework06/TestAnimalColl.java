/*
 * ���� ���������� (������ MK-JC1-50-20)
 * �. �����, 2020
 *
 * �������. (����: ���������, �����������, �����������)
 *
 * 1.������ ������ ��� �������� ���������� �� ��������:
 *   1.2. �������� ����� Animal:
 *        1.2.1. ����� age - ������� (�� 1 �� 15 ���)
 *        1.2.2. ������ nick - ������
 *
 * 2. ������� ����������� ��� ������� ������� ����������:
 *    2.3. ������� ��������
 *    2.4. ������� �������� � ������ �������� �� �������� (�������� ��������� � ������ 2.99)
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

public class TestAnimalColl {
    public static void main(String[] args) {
        long[][] timeOperations = new long[4][4];
        AnimalComparator aCompar = new AnimalComparator();

        // 3.2. ��������� ���������
        // 3.4.1. �������� ����� ���������� ���������

        //      3.2.1. LinkedList
        List<Animal> aLinkList = new LinkedList<>();
        long startTimer = System.currentTimeMillis();
        generateAnimalCollection(aLinkList);
        long stopTimer = System.currentTimeMillis();
        timeOperations[0][0] = stopTimer - startTimer;

        //      3.2.2. ArrayList
        List<Animal> aArrList = new ArrayList<>();
        startTimer = System.currentTimeMillis();
        generateAnimalCollection(aArrList);
        stopTimer = System.currentTimeMillis();
        timeOperations[1][0] = stopTimer - startTimer;

        //      3.2.3. HashSet
        Set<Animal> aHashSet = new HashSet<>();
        startTimer = System.currentTimeMillis();
        generateAnimalCollection(aHashSet);
        stopTimer = System.currentTimeMillis();
        timeOperations[2][0] = stopTimer - startTimer;

        //      3.2.4. TreeSet
        Set<Animal> aTreeSet = new TreeSet<>(aCompar);
        startTimer = System.currentTimeMillis();
        generateAnimalCollection(aTreeSet);
        stopTimer = System.currentTimeMillis();
        timeOperations[3][0] = stopTimer - startTimer;

        // 3.3. ������������� ��������� ��������� �����������.
        //      3.3.1. ��������� ����������� ���������� jdk
        Collections.sort(aLinkList, aCompar);
        Collections.sort(aArrList, aCompar);
        List<Animal> aList = new ArrayList<>(aHashSet);
        Collections.sort(aList, aCompar);
        // ��������� TreeSet ������ ��������������.

        //      3.3.2.* ��������� ����������� ������� ���������� (��� ��� ����������� �����������...)
        //sort(aLinkList, aCompar);
        //sort(aArrList, aCompar);
        //List<Person> aList = new ArrayList<>(aHashSet);
        //sort(aList, aCompar);


        // 3.4.2. �������� ����� ������������ ���������
        //        3.4.2.1. ��� ������ iterator
        timeOperations[0][1] = iterateCollection(aLinkList);
        timeOperations[1][1] = iterateCollection(aArrList);
        timeOperations[2][1] = iterateCollection(aHashSet);
        timeOperations[3][1] = iterateCollection(aTreeSet);

        // 3.4.2. �������� ����� ������������ ���������
        //        3.4.2.2. ��� ������ ������ ������� ������� (�� foreach)
        timeOperations[0][2] = iterateWithNoIterList(aLinkList);
        timeOperations[1][2] = iterateWithNoIterList(aArrList);
        timeOperations[2][2] = iterateWithNoIterSet(aHashSet);
        timeOperations[3][2] = iterateWithNoIterSet(aTreeSet);

        // 3.4.3. �������� ���� ��������� ��������� (������� ���� ��):
        //        3.4.3.1. ��� ������ iterator
        //        3.4.3.2. ��� ������ ������ ������� �������

        startTimer = System.currentTimeMillis();
        Iterator<Animal> iter = aLinkList.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        stopTimer = System.currentTimeMillis();
        timeOperations[0][3] = stopTimer - startTimer;

        startTimer = System.currentTimeMillis();
        for (int i = aArrList.size() - 1; i >= 0 ; i--) {
            aArrList.remove(i);
        }
        stopTimer = System.currentTimeMillis();
        timeOperations[1][3] = stopTimer - startTimer;

        startTimer = System.currentTimeMillis();
        Object[] tmp = aHashSet.toArray();
        int k = 0;
        while (aHashSet.size() > 0) {
            if (aHashSet.contains(tmp[k])) {
                aHashSet.remove(tmp[k]);
                k++;
            }
        }
        stopTimer = System.currentTimeMillis();
        timeOperations[2][3] = stopTimer - startTimer;
        tmp = null;

        startTimer = System.currentTimeMillis();
        iter = aTreeSet.iterator();
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
            System.out.printf("\n%-11s | %11d | %11d | %11d | %15d ",
                              collectionName[i], timeOperations[i][0], timeOperations[i][1],
                              timeOperations[i][2], timeOperations[i][3]);
        }
        System.out.println();
        System.out.println("\n   *����� � �������������.");
        System.out.println();
    }

    private static Collection<Animal> generateAnimalCollection(Collection<Animal> anim){
        String filePath = "homework/homework/homework06/pet_niks.txt";
        if(Files.exists(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS)){
            String str = readAllBytesJava7(filePath);
            String[] arrStr = str.split(", ");
            Random rnd = new Random();

            for (int i = 0; i < 150_000; i++) {
                anim.add(new Animal(arrStr[rnd.nextInt(arrStr.length)] + "_" +  i,
                                    rnd.nextInt(15) + 1));
            }
            return anim;
        }
        return null;
    }

    private static void printCollAnim(Collection<Animal> anim){
        System.out.println("\n-----------------------------------------------");
        for (Animal one: anim) {
            System.out.printf("%-20s : %3s\n", one.getNick(), one.getAge());
        }
        System.out.println("-----------------------------------------------");
    }
}

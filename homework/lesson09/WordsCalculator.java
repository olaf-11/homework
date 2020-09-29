/*
 * ���� ���������� (������ MK-JC1-50-20)
 * �. �����, 2020
 *
 * ������� 1-5. (����: ������ �� ��������, �����������. "����� � ���".)
 *
 * 1. ������� ����� "����� � ���"
 *    https://www.dropbox.com/s/8mstiwnx9o9btw4/%D0%B2%D0%BE%D0%B9%D0%BD%D0%B0%20%D0%B8%20%D0%BC%D0%B8%D1%80_%D0%BA%D0%BD%D0%B8%D0%B3%D0%B0.txt?dl=0
 *    �� ���������. ��������� ������
 *    https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
 *    � ����� readAllBytesJava7 �� ������ ������� ���������� ���� � ��������� ��������� �����������
 *    � ���������� ���� ���� String.
 *
 * 2. ������ � �����������:
 *    2.0. ����� ����������, ������� � �������� ����� - ��� �� �����.
 *         ������� � ������ ����� ��������.
 *    2.1. ����� � ������ ��� ���������� ����� � ��������� �� � ��������� ��������� Set.
 *    2.2. ����� � ������ ��� 10 ���� � ������� ���������� ���� ���� ��������� Map.
 *         ������������� �� ����������. ����������� � �������.
 *         ������: ����� - 200 ���, ��� - 100 ��� � ��� �����.
 *         ����� ����������, ������� � �������� ����� - ��� �� �����.
 *
 * 3. �������� ��������� ISearchEngine. ��� ����� ��������� � ������� ����� ������:
 *    3.1. long search(String text, String word) - ����� ���������� ���������� � ���������� ���
 *         ������� ����������� ����� � ������. ������ �������� ����� � ������� ����,
 *         ������ �������� ��� ���� � ������
 *
 * 4. ����������� ��������� ISearchEngine:
 *    4.1. �������� ����� EasySearch. ����������� ����� ��������� ����� indexOf
 *         �� ������ String. � ������ ���������� ��������� ������������ ���������� ���������
 *         � ����� ����, ��� ����� �����.
 *    4.2* �������� ����� RegExSearch ����������� ��������� ISearchEngine.
 *         ����������� ����� ��� ������ ������ Matcher.
 *
 * 5. ��������� ���������� ���������� ISearchEngine ������� ���������� ��� ����� �����������
 *    ����� "�����", "�" (��� ����), "���" ��� ����������� �� ��������.
 */
package lesson09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsCalculator {
    public static void main(String[] args) {
        //
        //String str = readAllBytesJava7("homework/homework/lesson09/����� � ���_�����-test1.txt");
        String str = readAllBytesJava7("homework/homework/lesson09/����� � ���_�����.txt");
        Map<String, Integer> wordsInBook = new HashMap<>();

        Pattern anyWord = Pattern.compile("[�-��-���]+-?([�-��-���]+)?"); // ������ ��� ������ ������ �����
        Matcher matchStr = anyWord.matcher(str); // ������� ������ ��� ������ ����������

        int count = 0;

        while (matchStr.find()) {
            // Do something, something
            // System.out.println(matchStr.group());
            if (!wordsInBook.containsKey(matchStr.group())){
                wordsInBook.put(matchStr.group(), 1);
                count++;
            } else {
                wordsInBook.put(matchStr.group(), wordsInBook.get(matchStr.group()) + 1);
                count++;
            }
        }

        /*System.out.println();
        for(Map.Entry<String, Integer> member : wordsInBook.entrySet()){
            System.out.printf("%-20s\t\t%d \n", member.getKey(), member.getValue());
        }
        System.out.println();

        System.out.println("����� ���� ���������: " + count);
        System.out.println();

        Collection<Integer> keys = wordsInBook.values();
        int sum = 0;
        for (Integer val: keys) {
            sum += val;
        }
        System.out.println("����� ���� ����������� � ���������: " + sum);
        System.out.println();
        System.out.println("����� ������ ��� �������� � ���������: " + wordsInBook.size());
        System.out.println(); */

        // ��������� ��� �������� ������
        Set<String> setOfWordsInBook = wordsInBook.keySet();
        //System.out.println("����� ���������� ����: " + setOfWordsInBook.size());

        //
        printTop(wordsInBook,10);

        //
        EasySearch eSearch = new EasySearch();
        //String sWord = "�";
        //long k = eSearch.search(str.toLowerCase(), sWord.toLowerCase());
        //System.out.println("����� \"" + sWord + "\" �����������: " + k + " ���.");
        String[] sWord = {"�����", "�", "���"};
        for (String w: sWord) {
            System.out.println("����� \"" + w + "\" �����������: " + eSearch.search(str.toLowerCase(), w.toLowerCase()) + " ���.");
        }

        System.out.println();
        RegExSearch regSearch = new RegExSearch();
        for (String w: sWord){
            System.out.println("����� \"" + w + "\" �����������: " + regSearch.search(str.toLowerCase(), w.toLowerCase()) + " ���.");
        }
        System.out.println();
    }

    private static String readAllBytesJava7(String filePath)
    {
        String content = "";

        try {
            //System.out.println(Paths.get(filePath).toAbsolutePath());
            content = new String (Files.readAllBytes(Paths.get(filePath)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    private static void printTop (Map<String, Integer> someMap, int num){
        //
        Map<String, Integer> sortedWordsMap = new LinkedHashMap<>();
        someMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sortedWordsMap.put(x.getKey(), x.getValue()));
        System.out.println();
        int i = 1;
        for(Map.Entry<String, Integer> member : sortedWordsMap.entrySet()){
            System.out.printf("%-20s -- %5d\n", member.getKey(), member.getValue());
            //System.out.println(member.getKey() + " -- " + member.getValue());
            i++;
            if (i > num) break;
        }
        System.out.println();
    }
}

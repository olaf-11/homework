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
        String str = readAllBytesJava7("homework/homework/lesson09/����� � ���_�����.txt");
        Map<String, Integer> wordsInBook = new HashMap<>();

        Pattern anyWord = Pattern.compile("[�-��-���]+-?([�-��-���]+)?"); // ������ ��� ������ ������ �����
        Matcher matchStr = anyWord.matcher(str); // ������� ������ ��� ������ ����������

        String[] sWord = {"�����", "�", "���"};// ��� ������� �� �.5

        while (matchStr.find()) {
            if (!wordsInBook.containsKey(matchStr.group())){
                wordsInBook.put(matchStr.group(), 1);
            } else {
                wordsInBook.put(matchStr.group(), wordsInBook.get(matchStr.group()) + 1);
            }
        }

        // 2.1. ����� � ������ ��� ���������� ����� � ��������� �� � ��������� ��������� Set.
        Set<String> setOfWordsInBook = wordsInBook.keySet();

        // 2.2. ����� � ������ ��� 10 ���� � ������� ���������� ���� ���� ��������� Map.
        printTop(wordsInBook,10);

        // 4.1. �������� ����� EasySearch...
        EasySearch eSearch = new EasySearch();

        // 5. ��������� ���������� ���������� ISearchEngine...
        for (String w: sWord) {
            System.out.println("����� \"" + w + "\" �����������: " +
                               eSearch.search(str.toLowerCase(), w.toLowerCase()) + " ���.");
        }
        System.out.println();

        // 4.2* �������� ����� RegExSearch...
        RegExSearch regSearch = new RegExSearch();

        // 5. ��������� ���������� ���������� ISearchEngine...
        for (String w: sWord){
            System.out.println("����� \"" + w + "\" �����������: " +
                                regSearch.search(str.toLowerCase(), w.toLowerCase()) + " ���.");
        }
        System.out.println();
    }

    // ����� ��� ���������� ����������� ����� � ���������� � ���������� ���� String.
    private static String readAllBytesJava7(String filePath)
    {
        String content = "";

        try {
            content = new String (Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    // ����� ������� �� ������ ��� @num ��������
    private static void printTop (Map<String, Integer> someMap, int num){
        Map<String, Integer> sortedWordsMap = new LinkedHashMap<>();
        someMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> sortedWordsMap.put(x.getKey(), x.getValue()));
        System.out.println("\n----------------------------------------");
        int i = 1;
        for(Map.Entry<String, Integer> member : sortedWordsMap.entrySet()){
            System.out.printf("%-20s -- %5d\n", member.getKey(), member.getValue());
            i++;
            if (i > num) break;
        }
        System.out.println("----------------------------------------\n");
    }
}

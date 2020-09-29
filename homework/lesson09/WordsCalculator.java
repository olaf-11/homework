/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задания 1-5. (Тема: Работа со строками, коллекциями. "Война и мир".)
 *
 * 1. Скачать книгу "Война и мир"
 *    https://www.dropbox.com/s/8mstiwnx9o9btw4/%D0%B2%D0%BE%D0%B9%D0%BD%D0%B0%20%D0%B8%20%D0%BC%D0%B8%D1%80_%D0%BA%D0%BD%D0%B8%D0%B3%D0%B0.txt?dl=0
 *    на компьютер. Используя статью
 *    https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
 *    и метод readAllBytesJava7 из статьи считать сохранённый файл и сохранить результат счтитывания
 *    в переменную типа типа String.
 *
 * 2. Работа с коллекциями:
 *    2.0. Знаки препинания, пробелы и переводы строк - это не слова.
 *         Регистр в словах имеет значение.
 *    2.1. Найти в строке все уникальные слова и поместить их в коллекцию используя Set.
 *    2.2. Найти в строке топ 10 слов и вывести количество этих слов используя Map.
 *         Отсортировать по количеству. Распечатать в консоль.
 *         Пример: Война - 200 раз, Мир - 100 раз и так далее.
 *         Знаки препинания, пробелы и переводы строк - это не слова.
 *
 * 3. Написать интерфейс ISearchEngine. Это будет интерфейс в котором будут методы:
 *    3.1. long search(String text, String word) - Метод возвращает информации о количестве раз
 *         которое встречается слово в тексте. Первый параметр текст в котором ищем,
 *         второй параметр что ищем в тексте
 *
 * 4. Реализовать интерфейс ISearchEngine:
 *    4.1. Написать класс EasySearch. Реализовать поиск используя метод indexOf
 *         из класса String. В данной реализации запрещено использовать регулярные выражения
 *         в любом виде, для любых задач.
 *    4.2* Написать класс RegExSearch реализующий интерфейс ISearchEngine.
 *         Реализовать поиск при помощи класса Matcher.
 *
 * 5. Используя реализации интерфейса ISearchEngine вывести информацию как часто встречаются
 *    слова "война", "и" (как союз), "мир" вне зависимости от регистра.
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
        String str = readAllBytesJava7("homework/homework/lesson09/Война и мир_книга.txt");
        Map<String, Integer> wordsInBook = new HashMap<>();

        Pattern anyWord = Pattern.compile("[А-Яа-яёЁ]+-?([А-Яа-яёЁ]+)?"); // шаблон для поиска любого слова
        Matcher matchStr = anyWord.matcher(str); // передаю строку для поиска совпадений

        String[] sWord = {"война", "и", "мир"};// Для задания из п.5

        while (matchStr.find()) {
            if (!wordsInBook.containsKey(matchStr.group())){
                wordsInBook.put(matchStr.group(), 1);
            } else {
                wordsInBook.put(matchStr.group(), wordsInBook.get(matchStr.group()) + 1);
            }
        }

        // 2.1. Найти в строке все уникальные слова и поместить их в коллекцию используя Set.
        Set<String> setOfWordsInBook = wordsInBook.keySet();

        // 2.2. Найти в строке топ 10 слов и вывести количество этих слов используя Map.
        printTop(wordsInBook,10);

        // 4.1. Написать класс EasySearch...
        EasySearch eSearch = new EasySearch();

        // 5. Используя реализации интерфейса ISearchEngine...
        for (String w: sWord) {
            System.out.println("Слово \"" + w + "\" встречается: " +
                               eSearch.search(str.toLowerCase(), w.toLowerCase()) + " раз.");
        }
        System.out.println();

        // 4.2* Написать класс RegExSearch...
        RegExSearch regSearch = new RegExSearch();

        // 5. Используя реализации интерфейса ISearchEngine...
        for (String w: sWord){
            System.out.println("Слово \"" + w + "\" встречается: " +
                                regSearch.search(str.toLowerCase(), w.toLowerCase()) + " раз.");
        }
        System.out.println();
    }

    // Метод для считывания содержимого файла и сохранения в переменную типа String.
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

    // Метод выводит не печать топ @num значений
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

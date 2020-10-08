/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание. (Тема: Коллекции, компараторы, полиморфизм)
 *
 * 1.Создаём классы для хранения информации об объектах:
 *   1.2. Написать класс Animal:
 *        1.2.1. Число age - возраст (от 1 до 15 лет)
 *        1.2.2. Строка nick - кличка
 *
 * 2. Создать компараторы для классов которые сравнивают:
 *    2.3. Возраст животных
 *    2.4. Возраст животных и клички животных по алфавиту (Смотрите уточнение в пункте 2.99)
 *    2.99. Особенность данных сортировок в том что у вас должна получиться сортировка по двум полям,
 *          сначала по первому, потом по второму. К примеру: есть список животных
 *          [{age: 10, nick: "Анатолий"}, {age: 10, "Игнат"}, {age: 1, nick: "Люцифер"}, {age: 10, "Ярик"}].
 *          После сортировки должно получиться: [{{age: 1, nick: "Люцифер"}, age: 10, nick: "Анатолий"},
 *          {age: 10, "Игнат"}, {age: 10, "Ярик"}]. Так как сначала сортируется по возрасту в порядке возрастания,
 *          а потом в рамках группу (age = 10), сортируется по кличке по возрастанию (по алфавиту).
 *
 * 3. Работа с коллекциями. Выполняем действия над экземплярами классов созданных на основания задания 1:
 *    3.1. При помощи рандома генерируем 1_000_000 (Если компьютер глючит сделать 100_000)
 *         разных объектов одного класса. Поля заполняются рандомными данными.
 *    3.2. Заполняем:
 *         3.2.1. LinkedList
 *         3.2.2. ArrayList
 *         3.2.3. HashSet
 *         3.2.4. TreeSet
 *    3.3. Отсортировать коллекции используя компараторы из задания 2.
 *         3.3.1. Сортируем встроенными средствами jdk
 *    3.4. Замерить время и распечатать консоль: "Операция: ХХХХ. Заняла YYYY мс".
 *         Для замера использовать метод из jdk System.currentTimeMillis():
 *         3.4.1. Заполнения коллекции
 *         3.4.2. Итерирования коллекции:
 *                3.4.2.1. При помощи iterator
 *                3.4.2.2. При помощи любого другого способа (не foreach)
 *         3.4.3. Удаления всех элементов коллекции (выбрать один из):
 *                3.4.3.1. При помощи iterator
 *                3.4.3.2. При помощи любого другого способа
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

        // 3.2. Заполняем коллекции
        // 3.4.1. Измеряем время заполнения коллекций

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

        // 3.3. Отсортировать коллекции используя компараторы.
        //      3.3.1. Сортируем встроенными средствами jdk
        Collections.sort(aLinkList, aCompar);
        Collections.sort(aArrList, aCompar);
        List<Animal> aList = new ArrayList<>(aHashSet);
        Collections.sort(aList, aCompar);
        // Коллекция TreeSet всегда отсортированна.

        //      3.3.2.* Сортируем собственным методом сортировки (млн лет пузырьковой сортировкой...)
        //sort(aLinkList, aCompar);
        //sort(aArrList, aCompar);
        //List<Person> aList = new ArrayList<>(aHashSet);
        //sort(aList, aCompar);


        // 3.4.2. Измерить время итерирования коллекции
        //        3.4.2.1. При помощи iterator
        timeOperations[0][1] = iterateCollection(aLinkList);
        timeOperations[1][1] = iterateCollection(aArrList);
        timeOperations[2][1] = iterateCollection(aHashSet);
        timeOperations[3][1] = iterateCollection(aTreeSet);

        // 3.4.2. Измерить время итерирования коллекции
        //        3.4.2.2. При помощи любого другого способа (не foreach)
        timeOperations[0][2] = iterateWithNoIterList(aLinkList);
        timeOperations[1][2] = iterateWithNoIterList(aArrList);
        timeOperations[2][2] = iterateWithNoIterSet(aHashSet);
        timeOperations[3][2] = iterateWithNoIterSet(aTreeSet);

        // 3.4.3. Удаления всех элементов коллекции (выбрать один из):
        //        3.4.3.1. При помощи iterator
        //        3.4.3.2. При помощи любого другого способа

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
                          "Тип", "Время", "Перебор", "Перебор", "Удаление");
        System.out.printf("\n%11s | %11s | %11s | %11s | %15s ",
                          "коллекции", "создания", "с Iterator", "не Iterator", "всех элементов");
        System.out.print("\n----------- | ----------- | ----------- | ----------- | --------------- ");
        for (int i = 0; i < collectionName.length; i++) {
            System.out.printf("\n%-11s | %11d | %11d | %11d | %15d ",
                              collectionName[i], timeOperations[i][0], timeOperations[i][1],
                              timeOperations[i][2], timeOperations[i][3]);
        }
        System.out.println();
        System.out.println("\n   *Время в миллисекундах.");
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

/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание. (Тема: Stream)
 * 1. Класс студента:
 *    1.1 Имя
 *    1.2 Фамилия
 *    1.3 Отчестова
 *    1.4 ФИО (подсказка: инкапсуляция)
 *    1.5 Оценка
 * 2. При загрузке приложения запрашивать адрес файла из которого мы будем
 *    десериализовать данные о студентах.
 *    2.1. Если ничего не указать то проверяется наличие файла students.bin
 *         относительно места запуска программы.
 *    2.2. Если файл не найден то генерируем в указанное место файл.
 *         2.2.1 При помощи Stream.generate() создать 10000 студентов
 *         2.2.2 Сохранить в коллекцию
 *         2.2.3 Коллекцию сохранить в файл
 *               2.2.3.1 При помощи механизма сериализации в бинарный файл
 *               2.2.3.2 При помощи сохранения каждого поля отдельно в текстовый файл
 * 3. Вывести top N по оценке, осортировать по имени
 * 4. Записать получившийся результат (топ N) в файл
 * 5. В новом классе (см. класс StudentsTopStream) прочитать этот файл
 *    и вывести последние N студентов.
 */
package homework09;

import homework09.root.Student;
import homework09.root.StudentComparator;
import homework09.utils.SaveTxtFile;
import homework09.utils.StudentsListGen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsStream {
    public static final String DEFAULT_PATH = "src/homework/homework09/students.bin";
    public static final String PATH_TXT = "src/homework/homework09/students.txt";
    public static final String DEFAULT_PATH_TOP = "src/homework/homework09/studentsTop.bin";

    //public static final String DEFAULT_PATH = "homework/homework/homework09/students.bin";
    //public static final String PATH_TXT = "homework/homework/homework09/students.txt";
    //public static final String DEFAULT_PATH_TOP = "homework/homework/homework09/studentsTop.bin";

    public static final StudentComparator stCompr = new StudentComparator();
    public static final long topN = 100;

    public static void main(String[] args) {
        String studentsFilePath = "";
        List<Student> students = null;

        if(args.length < 1){
            // Если не передали filePath, то берем файл по умолчанию:
            // DEFAULT_PATH
            studentsFilePath = DEFAULT_PATH;
        } else {
            // Если передали filePath
            studentsFilePath = args[0];
        }

        // Если filePath корректный
        if(Files.exists(Paths.get(studentsFilePath), LinkOption.NOFOLLOW_LINKS)) {
            try (ObjectInputStream in = new ObjectInputStream(
                                        new FileInputStream(studentsFilePath))) {

                students = (List) in.readObject();

            } catch (IOException exc){
                System.out.println(exc.getMessage());
            } catch (ClassNotFoundException exc){
                System.out.println(exc.getMessage());
            }
        } else {
            // Если файла нет по указанному пути, то
            // при помощи Stream.generate() создать 10000 студентов
            // и сохранить в коллекцию.
            students = StudentsListGen.create();

            // Коллекцию сохранить в файл.
            // 2.2.3.1. При помощи механизма сериализации в бинарный файл
            try (ObjectOutputStream out = new ObjectOutputStream(
                                          new FileOutputStream(studentsFilePath))) {

                out.writeObject(students);
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }

        // 2.2.3.2. При помощи сохранения каждого поля отдельно в текстовый файл
        SaveTxtFile.write(students, PATH_TXT);

        // 3. Вывести top N по оценке, осортировать по имени
        List<Student> topNStudents = students.stream()
                                             .sorted(new StudentComparator())
                                             .limit(topN)
                                             .sorted((o1, o2) -> o1.compareTo(o2))
                                             .collect(Collectors.toList());

        System.out.println();
        for (Student student : topNStudents) {
            System.out.println(student);
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Всего: " + topNStudents.size() + " наиболее замечательных студентов.\n");

        // 4. Записать получившийся результат (топ N) в файл
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(DEFAULT_PATH_TOP))) {

            out.writeObject(topNStudents);
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
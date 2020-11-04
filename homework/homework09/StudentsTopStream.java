/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * ...
 *
 * 5. В новом классе прочитать этот файл
 *    и вывести последние N студентов.
 */
package homework09;

import homework09.root.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.List;

public class StudentsTopStream {
    public static final int LAST_STUDENTS = 25;

    public static void main(String[] args) {
        //
        if(Files.exists(Paths.get(StudentsStream.DEFAULT_PATH_TOP), LinkOption.NOFOLLOW_LINKS)) {
            List<Student> studentsTop = null;
            long skipFirst;

            try (ObjectInputStream in = new ObjectInputStream(
                                        new FileInputStream(StudentsStream.DEFAULT_PATH_TOP))) {

                studentsTop = (List) in.readObject();

            } catch (IOException exc){
                System.out.println(exc.getMessage());
            } catch (ClassNotFoundException exc){
                System.out.println(exc.getMessage());
            }
            // Если кол-во студней больше чем нам надо вывести
            if (studentsTop.size() > LAST_STUDENTS) {
                skipFirst = studentsTop.size() - LAST_STUDENTS;
            } else {
                skipFirst = 0;
            }
            // Выводим в консоль:
            System.out.println("------------------------------------------------");
            studentsTop.stream()
                       .skip(skipFirst)
                       .forEach(System.out::println);
            System.out.println("------------------------------------------------");
        }
    }
}

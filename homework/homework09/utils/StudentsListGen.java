package homework09.utils;

import homework09.root.Student;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static homework06.Utility.readAllBytesJava7;

public class StudentsListGen {
    private static final int countOfStudent = 10_000;

    public static List<Student> create(){
        List<Student> list = new ArrayList<>();
        String filePath = "src/homework/homework06/names.txt";
        //String filePath = "homework/homework/homework06/names.txt";

        if(Files.exists(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS)) {
            String str = readAllBytesJava7(filePath);
            String[] arrStr = str.split(", ");
            Random rnd = new Random();

            //
            list = Stream.generate(() -> new Student(arrStr[rnd.nextInt(arrStr.length)],
                                            arrStr[rnd.nextInt(arrStr.length)] + "ко",
                                            arrStr[rnd.nextInt(arrStr.length)] + "ович",
                                            rnd.nextInt(50) / 10.0 + 5))
                         .limit(countOfStudent)
                         .collect(Collectors.toList());
        }
        return list;
    }
}

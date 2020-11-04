package homework09.utils;

import homework09.root.Student;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class SaveTxtFile {
    public static void write(List<Student> list, String file){
        Path filePath = Paths.get(file);
        OpenOption option;

        try (BufferedWriter writer = Files.newBufferedWriter(filePath,
                                     StandardOpenOption.WRITE,
                                     StandardOpenOption.CREATE)) {

            for (Student element : list) {
                writer.write("{" + element.getSurname() + ","
                                     + element.getName() + ","
                                     + element.getMiddleName() + ","
                                     + element.getAverageScore() + "}"
                                     + "\n");

            }

        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}

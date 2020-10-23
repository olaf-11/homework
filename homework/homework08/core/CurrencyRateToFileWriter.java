package homework08.core;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class CurrencyRateToFileWriter {
    private String defaultFileName;
    private Path filePath;


    public CurrencyRateToFileWriter(String fileName){
        defaultFileName = fileName;
    }

    private boolean isUserFilePath(String[] path) {
        return path != null && path.length == 1;
        //&& Files.exists(Paths.get(path[0].replaceAll("\"", "")));
    }

    public void write(double rate, SiteLoader.Currency currency) {
        // Если файл есть -- записываем в конец, если нет файла -- создаем файл.
        OpenOption option;
        if (Files.notExists(filePath)) {
            option = StandardOpenOption.CREATE;
        } else {
            option = StandardOpenOption.APPEND;
        }
        // XXX   Files.isWritable(filePath); ???
        //
        try (BufferedWriter writer = Files.newBufferedWriter(filePath,
                StandardOpenOption.WRITE, option)) {
            writer.write(currency + ": " + rate + "\n");
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public void setPathToWrite(String[] path){
        if(isUserFilePath(path)){
            try{
                filePath = Paths.get(path[0].replaceAll("\"", ""));
            } catch (InvalidPathException exc) {
                System.out.println("Пользовательский путь неверный!");
                System.out.println(exc.getMessage());
                filePath = Paths.get(defaultFileName);
            }
        } else {
            filePath = Paths.get(defaultFileName);
        }
    }

    public String getDefaultFileName() {
        return defaultFileName;
    }

    public Path getFilePath() {
        return filePath;
    }
}

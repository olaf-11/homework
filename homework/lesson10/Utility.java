package lesson10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Utility {
    public static <T> long iterateCollection(Collection<T> tColl){
        Iterator<T> iterator = tColl.iterator();
        long start = System.currentTimeMillis();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public static <T> long iterateWithNoIterList(List<T> tList){
        long start = System.currentTimeMillis();
        for (int j = 0; j < tList.size(); j++) {
            tList.get(j);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public static <T> long iterateWithNoIterSet(Set<T> tSet){
        long start = System.currentTimeMillis();
        Object[] arr = tSet.toArray();
        for (int j = 0; j < arr.length; j++) {
            T tmp = (T) arr[j];
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }


    public static String readAllBytesJava7(String filePath)
    {
        String content = "";
        //System.out.println(Files.exists(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS));

        try {
            //System.out.println(Paths.get(filePath).toAbsolutePath());
            content = new String (Files.readAllBytes(Paths.get(filePath)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}

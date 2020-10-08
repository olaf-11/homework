package homework06;

import homework04.DataContainer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Utility {

    public static <T> void sort(List<T> tList, Comparator<T> tListComparator){
        if(tList.size() > 1) {
            for (int i = 0; i < tList.size(); i++) {
                boolean isSwap = false;
                for (int j = tList.size() - 1; j > i; j--) {
                    if (tListComparator.compare(tList.get(j - 1), tList.get(j)) > 0) {
                        isSwap = swapIt(tList, j - 1, j);
                    }
                }
                if (!isSwap) break; // Если не было перестановок
            }
        }
    }

    private static <T> boolean swapIt (List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
        return true;
    }

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

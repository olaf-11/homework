package homework05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine{
    @Override
    public long search(String text, String word) {
        if (!text.equals("") && !word.equals("")) {
            Pattern anyWord = Pattern.compile("\\b" + word + "\\b");
            Matcher matchStr = anyWord.matcher(text);
            long sum = 0;
            while (matchStr.find()) {
                sum++;
            }
            return sum;
        }
        return -1L;
    }
}

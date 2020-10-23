package homework05;

public class EasySearch implements ISearchEngine{
    @Override
    public long search(String text, String word) {
        if (!text.equals("") && !word.equals("")) {
            int cursor = -1;
            long sum = 0;
            boolean isPrevRight, isNextRight;
            while ((cursor = text.indexOf(word, cursor + 1)) >= 0) {

                // проверяю символ перед словом
                isPrevRight = cursor - 1  < 0 || checkBorders(text.charAt(cursor - 1));

                // проверяю символ после слова
                isNextRight = (cursor + word.length() > text.length() - 1) || checkBorders(text.charAt(cursor + word.length()));

                // если слово не в составе другого слова
                if(isPrevRight && isNextRight){
                    sum++;
                    cursor += word.length() - 1;
                }
                cursor++;
            }
            return sum;
        }
        return -1L;
    }
    
    // Служебный метод для проверки, что слово не в составе другого слова
    private boolean checkBorders (char ch){
        // Если символ не принадлежит буквенному диапазону или не "Ё", и не дефис "-"
        return !(ch > 'А' && ch < 'я') && !(ch == 'ё' || ch == 'Ё' || ch == '-');
    }
}

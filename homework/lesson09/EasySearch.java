package lesson09;

public class EasySearch implements ISearchEngine{
    @Override
    public long search(String text, String word) {
        if (!text.equals("") && !word.equals("")) {
            int cursor = -1;
            long sum = 0;
            boolean isPrevRight, isNextRight;
            while ((cursor = text.indexOf(word, cursor + 1)) >= 0) {

                // �������� ������ ����� ������
                isPrevRight = cursor - 1  < 0 || checkBorders(text.charAt(cursor - 1));
            /*if (chPrev < 0){
                isPrevRight = true;
            } else {
                isPrevRight = checkBorders(text.charAt(chPrev));
            }*/

                // �������� ������ ����� �����
                isNextRight = (cursor + word.length() > text.length() - 1) || checkBorders(text.charAt(cursor + word.length()));
            /*if (chNext > text.length() - 1){
                isNextRight = true;
            } else {
                isNextRight = checkBorders(text.charAt(chNext));
            }*/

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
    
    // ��������� ����� ��� ��������, ��� ����� �� � ������� ������� �����
    boolean checkBorders (char ch){
        // ���� ������ �� ����������� ���������� ��������� ��� �� "�", � �� ����� "-"
        return !(ch > '�' && ch < '�') && !(ch == '�' || ch == '�' || ch == '-');
    }
}
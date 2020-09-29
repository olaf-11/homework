package lesson08;

public class TestSpellingNumbers {
    public static void main(String[] args) {
        SpellingNumbers sn = new SpellingNumbers();

        System.out.println();
        for (int i = 0; i < 100; i+=1) {
            System.out.println(i + " :  " + sn.toString(i));
        }
        System.out.println();
    }
}

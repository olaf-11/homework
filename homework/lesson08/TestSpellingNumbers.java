package lesson08;

public class TestSpellingNumbers {
    public static void main(String[] args) {
        SpellingNumbers sn = new SpellingNumbers();

        double dNumber = -256783457.2342345;
        //System.out.println();
        //for (long i = 897089000; i < 1000_000_000_000L; i += 136733843) {
        //    System.out.println(i + " : " + sn.toString(i));
        //}
        System.out.println(dNumber + " : " + sn.toString(dNumber));
        System.out.println();

        // int day = 277;
        //for (int i = 0; i < 367; i += 7) {
        //    System.out.println("Дней c начала года: " + i + " -- это " + sn.toWeek(i));
        //}
        System.out.println();
    }
}

package lesson02;

public class OlegTask3 {
    public static void main(String[] args) {

        /* Знакомство с библиотекой Math */
        double d = -17.5012;
        System.out.println("Округление к наибольшему целому (" + d + "): " + Math.ceil(d));
        System.out.println("Округление к наименьшему целому (" + d + "): " + Math.floor(d));

        System.out.println("\nОкругление к наибольшему целому (abs(" + d + ")): " + Math.ceil(Math.abs(d)));
        System.out.println("Округление к наименьшему целому (abs(" + d + ")): " + Math.floor(Math.abs(d)));

        double f = 32.053;
        System.out.println("\nБольшее число (" + f + " , " + d + "):  " + Math.max(d, f));
        System.out.println("Меньшее число (" + f + " , " + d + "): " + Math.min(d, f));

        double g = 625;
        System.out.println("\nКорень квадратный числа " + (int) g + ": " + Math.sqrt(g));
        System.out.println("2 в степени 16 = " + (int) Math.pow(2, 16));

        System.out.println("\nsin числа PI/2: " + Math.sin(Math.PI / 2));
        System.out.println("cos числа PI/2: " + Math.floor(Math.cos(Math.PI / 2)));
        System.out.println("cos 90 градусов: " + Math.floor((Math.cos(Math.toRadians(90)))));

        System.out.println("\nПсевдослучайное число в диапазоне от 1000 до 9999: " + (int) (Math.random() * 8999 + 1000));
    }
}

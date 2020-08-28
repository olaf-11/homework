package lesson02;

public class OlegTask4 {
    public static boolean isWeekday = false;
    public static boolean isVacation = false;

    public static void main(String[] args) {
        if(sleepIn(isWeekday, isVacation)){
            System.out.println("Спи спокойно, дорогой товарищ!");
        } else {
            System.out.println("Подъём! На работу бегом!");
        }
    }

    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation){
            return true;
        } else {
            return false;
        }

        /* Можно без else написать
         * return false;
         * потому что команды после return не выполняются: */
        // if (!weekday || vacation){
        //     return true;
        // }
        // return false;
    }
}

package lesson02;

public class OlegTask6 {
    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[] {0, 2, 9, 7, 7, 7, 9, 9, 9, 0}));
    }

    /* Формирует из массива строку вида: (029) 777-9990 */
    public static String createPhoneNumber(int[] arr) {
        String str = "(";

        for (int i = 0; i < 10; i++){
            str += arr[i];
            if (i == 2){
                str += ") ";
            }
            if(i == 5){
                str += "-";
            }
        }
        return str;
    }
}

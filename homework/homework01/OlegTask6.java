/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 6. (Тема: операторы)
 * Создать СТАТИЧЕСКИЙ метод createPhoneNumber рядом с методом main.
 * Данный метод будет принимает один параметр и будет возвращать строку
 * в отформатированном виде. В метод будет передаваться массив из 10 цифр (от 0 до 9).
 * Данные цифры должны быть помещены в строку формата: (XXX) XXX-XXXX.
 * Например передан массив: {1,2,3,4,5,6,7,8,9,0}, возвращаемый результат: (123) 456-7890.
 */
package homework01;

public class OlegTask6 {
    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[] {0, 2, 9, 7, 7, 7, 9, 9, 9, 0}));
    }

    /* Метод формирует из массива строку вида: (029) 777-9990 */
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

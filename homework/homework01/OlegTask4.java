/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 4. (Тема: операторы)
 * Создать СТАТИЧЕСКИЙ метод sleepIn рядом с методом main.
 * 4.1 Данный метод будет принимает два параметра
 * 4.2 Будет отвечать на вопрос спать ли дальше (возвращать true либо false).
 * 4.3 Первый параметр boolean weekday обозначает рабочий день
 * 4.4 Второй параметр boolean vacation обозначает отпуск.
 * 4.5 Если у нас отпуск или не рабочий день то мы можем спать дальше
 * 4.6 На основании ответа от метода sleepIn вывести сообщение можем спать дальше или пора идти на работу
 */
package homework01;

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
        return !weekday || vacation;
    }
}

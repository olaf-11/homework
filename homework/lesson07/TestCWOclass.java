/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 1, 2. (Тема: ООП, Калькулятор)
 * 1. Создать класс CalculatorWithOperator, все методы в данном классе НЕ статические.
 *    В классе CalculatorWithOperator должны присутствовать:
 *    1.1. 4 метода (деления, умножение, вычитание, сложение)
 *         каждый из этих методов должен принимать два параметра (определитесь с их типами)
 *         и должны возвращать результать (определиться с возвращаемым типом результата)
 *         при помощи ключевого слово return.
 *    1.2. Также должно быть ещё 2-3 метода
 *         (возведение в степень дробного положительного числа в целую степень,
 *         модуль числа, корень из числа**). В методах можно использовать оператор + / * -.
 *         Использование библиотеки Math ЗАПРЕЩЕНО!.
 *
 * 2. В отдельном классе, создать мэйн метод. Внутри данного метода создать
 *    экземпляр класса CalculatorWithOperator сохранив его в переменную.
 *    При помощи методов созданного объекта вычислить результат выражения
 *    4.1 + 15 * 7 + (28 / 5) ^ 2. Результат записать в переменную
 *    (определить самый подходящий тип переменной). Вывести сохранённый результат в консоль.
 *    Внимание, знак "^" обозначает возведение в степень.
 *    2.1. Далее сохранённый результат попробовать поделить на 0
 *         (если возникнет ошибка закомментировать и прокоментировать почему).
 *    2.2. Далее сохранённый результат попробовать поделить на 0.0d
 *         (если возникнет ошибка закомментировать и прокоментировать почему).
 */
package lesson07;

public class TestCWOclass {
    public static void main(String[] args) {
        CalculatorWithOperator calcWO = new CalculatorWithOperator();

        double result = calcWO.addNums(calcWO.addNums(4.1, calcWO.multiplyNums(15, 7)),
                                       calcWO.powNums(calcWO.divideNums(28, 5), 2));
        System.out.println("4.1 + 15 * 7 + (28 / 5) ^ 2 = "+ result);

        /*
         * Результат Infinity - бесконечность. В вычислениях типа double может получиться не точно ноль,
         * а некое бесконечно малое число (приближенное к нулю 0.00000000000000000 .. 001).
         * При делении числа на бесконечно малую величину получаем бесконечно большую величину
         * (бесконечно больше чем Double.MAX_VALUE).
         */
        System.out.println("result / 0.0D = " + (result / 0.0D));

        // Результат Infinity. Тоже самое. Ноль неявно приводится к типу double.
        System.out.println("result / 0    = " + (result / 0));
    }
}

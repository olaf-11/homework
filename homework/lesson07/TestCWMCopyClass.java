/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 4, 5. (Тема: ООП, Калькулятор)
 * 1. Создать класс CalculatorWithMathCopy, все методы в данном классе НЕ статические.
 *    В классе CalculatorWithMathCopy должны присутствовать:
 *    1.1. должны присутствовать 4 метода (деления, умножение, вычитание, сложение)
 *         данные методы можно скопировать из класса CalculatorWithOperator.
 *    1.2. В методах (возведение в степень, модуль числа, корень из числа) можно использовать
 *         только вызовы  методов библиотеки Math, все методы в данном классе НЕ статические.
 *
 * 2. В отдельном классе, создать мэйн метод. Внутри данного метода создать
 *    экземпляр класса CalculatorWithMathCopy сохранив его в переменную.
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

public class TestCWMCopyClass {
    public static void main(String[] args) {
        CalculatorWithMathCopy calcWO = new CalculatorWithMathCopy();

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

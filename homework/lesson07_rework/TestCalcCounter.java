/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 8*, 9*. (Тема: ООП, Калькулятор)
 * 8. Создать класс CalculatorWithCounter, все методы в данном классе НЕ статические.
 *    У данного класса должно быть три конструктора (или один если сможете, это ещё
 *    не изучено https://refactoring.guru/ru/design-patterns/decorator):
 *    один принимающий в себя CalculatorWithOperator, второй CalculatorWithMathCopy,
 *    третий CalculatorWithMathExtends. Данные конструкторы должны сохранять переданные
 *    калькуляторы в приватные поля класса для дальнейшего их использования.
 *    Он также имеет 7 методов как и другие калькуляторы + 1 метод getCountOperation()
 *    который должен вернуть значение внутреннего счётчика. В реализации методов
 *    должен быть вызван один из объектов переданный в констуктор при создании
 *    объекта CalculatorWithCounter, и вызвать соответсвующий метод у них.
 *    К примеру. Если вызывают метод plus у CalculatorWithCounter то он должен вызвать
 *    метод plus у объекта CalculatorWithOperator или у объекта CalculatorWithMathCopy
 *    или у объекта  CalculatorWithMathExtends (смотря что передали в конструктор)
 *    и увеличить значение внутреннего счётчика операций.
 *
 * 9. В отдельном классе, создать мэйн метод. Внутри данного метода создать
 *    экземпляр класса CalculatorWithCounter сохранив его в переменную.
 *    При помощи методов созданного объекта вычислить результат выражения
 *    4.1 + 15 * 7 + (28 / 5) ^ 2. Результат записать в переменную
 *    (определить самый подходящий тип переменной). Вывести сохранённый результат в консоль.
 *    Внимание, знак "^" обозначает возведение в степень.
 */
package lesson07_rework;

import lesson07_rework.root.*;

public class TestCalcCounter {
    public static void main(String[] args) {
        CalculatorWithCounter calcCounter = new CalculatorWithCounter(new CalculatorWithOperator());

        double result = calcCounter.plus(calcCounter.plus(4.1, calcCounter.multi(15, 7)),
                        calcCounter.power(calcCounter.div(28, 5), 2));
        System.out.println("\n4.1 + 15 * 7 + (28 / 5) ^ 2 = " + result);
        System.out.println("Число операций совершено: " + calcCounter.getCountOperation());
    }
}

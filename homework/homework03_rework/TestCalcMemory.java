/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание 10*, 11*. (Тема: ООП, Калькулятор)
 * 10.  Создать CalculatorWithMemory, принципы как и в задании 9, сможете)?.
 *      Данный калькулятор работает как настоящий калькулятор с функцией памяти.
 *      Функция памяти работает через два метода, записать в память результат выполнения
 *      последнего вызванного метода, получить из памяти записанное значение.
 *      При получении записи из памяти память стирается, при записи нового значения
 *      память перезаписывается.
 *
 * 11.  Большое выражение 4.1 + 15 * 7 + (28 / 5) ^ 2
 *      разделить на мелкие выражения в отдельных сроках выполнить данные выражения
 *      получая из памяти прошлый результат и записывая новый.
 */
package homework03_rework;

import homework03_rework.root.*;

public class TestCalcMemory {
    public static void main(String[] args) {
        CalculatorWithMemory calc = new CalculatorWithMemory(new CalculatorWithOperator());

        calc.div(28, 5);
        calc.saveInMemory();
        calc.power(calc.getFromMemory(), 2);
        calc.saveInMemory();
        calc.plus(calc.getFromMemory(), calc.multi(15, 7));
        calc.saveInMemory();
        calc.plus(calc.getFromMemory(), 4.1);
        calc.saveInMemory();

        System.out.println("\n4.1 + 15 * 7 + (28 / 5) ^ 2 = " + calc.getFromMemory());

        // Проверяем тот факт, что память стирается после извлечения значения.
        System.out.println("Теперь в памяти установлено значение: " + calc.getFromMemory());
    }
}

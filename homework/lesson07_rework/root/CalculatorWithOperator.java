package lesson07_rework.root;

import static java.lang.Double.NaN;

public class CalculatorWithOperator implements ICalcBaseOperate {
    /**
     * Метод plus суммирует 2 числа: @param n + @param m
     * @return возвращает их сумму.
     */
    public double plus(double n, double m){
        return n + m;
    }

    /**
     * Метод minus вычитает из числа @param n число @param m
     * @return возвращает разницу.
     */
    public double minus(double n, double m){
        return n - m;
    }

    /**
     * Метод multi умножает 2 числа: @param n * @param m
     * @return возвращает их произведение.
     */
    public double multi(double n, double m){
        return n * m;
    }

    /**
     * Метод div делит число @param n на число @param m
     * @return возвращает частное типа double не зависимо от типа входных данных.
     */
    public double div(double n, double m){
        return n / m;
    }

    /**
     * Метод power возвоздит число @param n в степень @param a
     * @return возвращает результат возведения числа в степень.
     * Степень @param a должна быть целым положительным числом.
     */
    public double power(double n, int a){
        for (int i = 1; i < a; i++) {
            n *= n;
        }
        return n;
    }

    /**
     * Метод abs преобразует число @param n по модулю.
     * @return возвращает положительную часть числа n без знака.
     * Методы перегружены для разных типов входных данных.
     */
    public double abs(double n){ return (n < 0.0D) ? - n : n; }

    /**
     * Метод sqrt вычисляет корень квадратный положительного числа @param n.
     * @return возвращает приблизительное число корня квадратного
     * с точностью до 6-го знака после нуля.
     */
    public double sqrt(double n){
        // Если число отрицательное -- корень не существует в области вещественных чисел.
        if (n < 0.0D) return NaN;

        final double PRECISION = 0.000001D;
        double x;

        // Если число n больше 1, то начальное значение 1
        if (n > 1){
            x = 1D;
        } else {
            // Если число n в диапазоне (0..1], не превышая точности @PRECISION, то нач. знач. = 0.000000001
            x = 0.000000001D;
        }
        while (true) {
            double temp = (x + n / x) / 2;
            if (abs(x - temp) < PRECISION) break;
            x = temp;
        }
        return x;
    }
}

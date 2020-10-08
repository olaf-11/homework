package homework03;

import static java.lang.Double.NaN;

public class CalculatorWithOperator {
    /**
     * Метод addNums суммирует 2 числа: @param n + @param m
     * @return возвращает их сумму.
     * Методы перегружены для разных типов данных.
     */
    public int addNums (int n, int m){
        return n + m;
    }

    public long addNums(long n, long m) {
        return n + m;
    }

    public float addNums(float n, float m){
        return n + m;
    }

    public double addNums(double n, double m){
        return n + m;
    }

    /**
     * Метод subtractNums вычитает из числа @param n число @param m
     * @return возвращает разницу.
     * Методы перегружены для разных типов данных.
     */
    public int subtractNums (int n, int m){
        return n - m;
    }

    public long subtractNums(long n, long m) {
        return n - m;
    }

    public float subtractNums(float n, float m){
        return n - m;
    }

    public double subtractNums(double n, double m){
        return n - m;
    }

    /**
     * Метод multiplyNums умножает 2 числа: @param n * @param m
     * @return возвращает их произведение.
     * Методы перегружены для разных типов данных.
     */
    public int multiplyNums(int n, int m){
        return n * m;
    }

    public long multiplyNums(long n, long m) {
        return n * m;
    }

    public float multiplyNums(float n, float m){
        return n * m;
    }

    public double multiplyNums(double n, double m){
        return n * m;
    }

    /**
     * Метод divideNums делит число @param n на число @param m
     * @return возвращает частное типа double не зависимо от типа входных данных.
     * Методы перегружены для разных типов входных данных.
     */
    public double divideNums(int n, int m){
        return (double) n / m;
    }

    public double divideNums(long n, long m) {
        return (double) n / m;
    }

    public double divideNums(float n, float m){
        return (double) n / m;
    }

    public double divideNums(double n, double m){
        return n / m;
    }

    /**
     * Метод powNums возвоздит число @param n в степень @param a
     * @return возвращает результат возведения числа в степень.
     * Степень @param a должна быть целым положительным числом.
     */
    public double powNums(double n, int a){
        for (int i = 1; i < a; i++) {
            n *= n;
        }
        return n;
    }

    // abs(n)

    /**
     * Метод absNum преобразует число @param n по модулю.
     * @return возвращает положительную часть числа n без знака.
     * Методы перегружены для разных типов входных данных.
     */
    public int absNum(int n){ return (n < 0) ? -n : n; }

    public long absNum(long n) { return (n < 0) ? -n : n; }

    public float absNum(float n){ return (n <= 0.0F) ? 0.0F - n : n; }

    public double absNum(double n){ return (n <= 0.0D) ? 0.0D - n : n; }

    /**
     * Метод sqrtNum вычисляет корень квадратный положительного числа @param n.
     * @return возвращает приблизительное число корня квадратного
     * с точностью до 6-го знака после нуля.
     */
    public double sqrtNum(double n){
        // Если число отрицательное -- корень не существует в области вещественных чисел.
        if (n < 0.0D) return NaN;

        final double PRECISION = 0.000001D;
        double x;

        // Число больше 1 или в диапазоне (0..1], не превышая точности @PRECISION
        if (n > 1){
            x = 1D;
        } else {
            x = 0.000000001D;
        }
        while (true) {
            double temp = (x + n / x) / 2;
            if (absNum(x - temp) < PRECISION) break;
            x = temp;
        }
        return x;
    }
}

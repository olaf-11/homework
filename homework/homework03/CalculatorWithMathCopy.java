package homework03;

public class CalculatorWithMathCopy {
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

    // Возведение числа в степень (n ^ a) переопределено c помощью библиотеки Math
    public double powNums(double n, int a){ return Math.pow(n, a); }

    // Модуль числа absNum(n) переопределен c помощью библиотеки Math
    public int absNum(int n){ return Math.abs(n); }

    public long absNum(long n) { return Math.abs(n); }

    public float absNum(float n){ return Math.abs(n); }

    public double absNum(double n){ return Math.abs(n); }

    // Корень квадратный sqrtNum(n) переопределен c помощью библиотеки Math
    public double sqrtNum(double n){ return Math.sqrt(n); }
}

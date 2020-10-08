package homework03;

public class CalculatorWithMathExtends extends CalculatorWithOperator {
    // Модуль числа absNum(n) переопределен c помощью библиотеки Math
    public int absNum(int n){ return Math.abs(n); }

    public long absNum(long n) { return Math.abs(n); }

    public float absNum(float n){ return Math.abs(n); }

    public double absNum(double n){ return Math.abs(n); }

    // Возведение числа в степень (n ^ a) переопределено c помощью библиотеки Math
    public double powNums(double n, int a){ return Math.pow(n, a); }

    // Корень квадратный sqrtNum(n) переопределен c помощью библиотеки Math
    public double sqrtNum(double n){ return Math.sqrt(n); }
}

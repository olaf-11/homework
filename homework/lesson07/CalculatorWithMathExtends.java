package lesson07;

public class CalculatorWithMathExtends extends CalculatorWithOperator {
    // abs(n) -- переопределение c помощью библиотеки Math
    public int addNums (int n){ return Math.abs(n); }

    public long addNums(long n) { return Math.abs(n); }

    public float addNums(float n){ return Math.abs(n); }

    public double addNums(double n){ return Math.abs(n); }

    //sqrt(n) -- переопределение c помощью библиотеки Math
    public double sqrtNums(double n){ return Math.sqrt(n); }
}

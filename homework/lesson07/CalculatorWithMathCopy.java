package lesson07;

public class CalculatorWithMathCopy {
    // n + m
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

    // n - m
    public int subtractNums (int n, int m){ return n - m; }

    public long subtractNums(long n, long m) {
        return n - m;
    }

    public float subtractNums(float n, float m){
        return n - m;
    }

    public double subtractNums(double n, double m){ return n - m; }

    // n * m
    public int multiplyNums(int n, int m){ return n * m; }

    public long multiplyNums(long n, long m) { return n * m; }

    public float multiplyNums(float n, float m){
        return n * m;
    }

    public double multiplyNums(double n, double m){ return n * m; }

    // n / m
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

    // n ^ a -- c помощью библиотеки Math
    public double powNums(double n, int a){ return Math.pow(n, a); }

    // abs(n) -- c помощью библиотеки Math
    public int addNums (int n){ return Math.abs(n); }

    public long addNums(long n) { return Math.abs(n); }

    public float addNums(float n){ return Math.abs(n); }

    public double addNums(double n){ return Math.abs(n); }

    //sqrt -- c помощью библиотеки Math
    public double sqrtNums(double n){ return Math.sqrt(n); }
}

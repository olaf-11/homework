package lesson07;

public class CalculatorWithOperator {
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

    // n ^ a
    public double powNums(double n, int a){
        for (int i = 1; i < a; i++) {
            n *= n;
        }
        return n;
    }

    // abs(n)
    public int addNums (int n){ return (n < 0) ? -n : n; }

    public long addNums(long n) { return (n < 0) ? -n : n; }

    public float addNums(float n){ return (n <= 0.0F) ? 0.0F - n : n; }

    public double addNums(double n){ return (n <= 0.0D) ? 0.0D - n : n; }

    //sqrt
}

package homework03_rework.root;

public class CalculatorWithMathCopy implements ICalcBaseOperate {
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

    // Переопределяем метод через библиотеку Math
    public double power(double n, int a){
        return Math.pow(n, a);
    }

    // Переопределяем метод через библиотеку Math
    public double abs(double n){
        return Math.abs(n);
    }

    // Переопределяем метод через библиотеку Math
    public double sqrt(double n){
        return Math.sqrt(n);
    }
}

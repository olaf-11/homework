package lesson07_rework.root;

public class CalculatorWithMathExtends extends CalculatorWithOperator implements ICalcBaseOperate {

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

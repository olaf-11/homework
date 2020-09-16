package lesson07_rework.root;

public class CalculatorWithCounter implements IOperationCount {

    private final ICalcBaseOperate calc;
    private long counter = 0;

    public CalculatorWithCounter (ICalcBaseOperate anyCalc){
        calc = anyCalc;
    }

    public double plus(double n, double m){
        counter++;
        return calc.plus(n, m);
    }

    public double minus(double n, double m){
        counter++;
        return calc.minus(n, m);
    }

    public double div(double n, double m){
        counter++;
        return calc.div(n, m);
    }

    public double multi(double n, double m){
        counter++;
        return calc.multi(n, m);
    }

    public double abs(double n){
        counter++;
        return calc.abs(n);
    }

    public double power(double n, int a){
        counter++;
        return calc.power(n, a);
    }

    public double sqrt(double n){
        counter++;
        return calc.sqrt(n);
    }

    public long getCountOperation() {
        return counter;
    }
}

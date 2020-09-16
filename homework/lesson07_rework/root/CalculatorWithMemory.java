package lesson07_rework.root;

import javax.naming.NameNotFoundException;

public class CalculatorWithMemory implements ICalcBaseOperate, IMemoryOperate {
    private final ICalcBaseOperate calc;
    private double lastOperationValue;
    private double MemoryValue;

    public CalculatorWithMemory (ICalcBaseOperate anyCalc){
        calc = anyCalc;
    }

    public double plus(double n, double m){
        lastOperationValue = calc.plus(n, m);
        return lastOperationValue;
    }

    public double minus(double n, double m){
        lastOperationValue = calc.minus(n, m);
        return lastOperationValue;
    }

    public double div(double n, double m){
        lastOperationValue = calc.div(n, m);
        return lastOperationValue;
    }

    public double multi(double n, double m){
        lastOperationValue = calc.multi(n, m);
        return lastOperationValue;
    }

    public double abs(double n){
        lastOperationValue = calc.abs(n);
        return lastOperationValue;
    }

    public double power(double n, int a){
        lastOperationValue = calc.power(n, a);
        return lastOperationValue;
    }

    public double sqrt(double n){
        lastOperationValue = calc.sqrt(n);
        return lastOperationValue;
    }

    public void saveInMemory(){
        MemoryValue = lastOperationValue;
    }

    public double getFromMemory(){
        double temp = MemoryValue;
        MemoryValue = Double.NaN;
        return temp;
    }
}

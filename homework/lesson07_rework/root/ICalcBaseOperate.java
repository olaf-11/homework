package lesson07_rework.root;

public interface ICalcBaseOperate {
    // Базовые операции
    double plus(double n, double m);
    double minus(double n, double m);
    double div(double n, double m);
    double multi(double n, double m);
    // Расширенные операции
    double abs(double n);
    double power(double n, int a);
    double sqrt(double n);
}

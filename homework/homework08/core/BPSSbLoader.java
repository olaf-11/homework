package homework08.core;
/**
 * Загрузчик курса с сайта БПС-Сбербанк
 */
public class BPSSbLoader extends CommersSiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double[] load(Currency currencyName) {
        return load("https://www.bps-sberbank.by/rates/rates.json", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double[] handle(String content, Currency currencyName) {

        System.out.println(content);
        //TODO: 1. Найти блок currencyName в строке content
        //TODO: 2. НАйти курс покупки, курс продажи
        //TODO:

        //try {
        //    return Double.parseDouble(content.substring(content.indexOf("OfficialRate") + 14, content.indexOf('}')));
        //} catch(NullPointerException exc) {
        //    System.out.println("Ошибка! Нам передали пустую строку, вместо числа.");
        //    return 0.0;
        //} catch(NumberFormatException exc) {
        //    System.out.println("Ошибка! Нам передали не число.");
        //    return 0.0;
        //}
        double[] arr = {0.0, 0.0};
        return arr;
    }
}

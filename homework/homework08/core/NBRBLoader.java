package homework08.core;
/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class NBRBLoader extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(SiteLoader.Currency currencyName) {
        return load("https://www.nbrb.by/api/exrates/rates/" + currencyName.getId(), currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, SiteLoader.Currency currencyName) {
        try {
            return Double.parseDouble(content.substring(content.indexOf("OfficialRate") + 14, content.indexOf('}')));
        } catch(NullPointerException exc) {
            System.out.println("Ошибка! Нам передали пустую строку, вместо числа.");
            return 0.0;
        } catch(NumberFormatException exc) {
            System.out.println("Ошибка! Нам передали не число.");
            return 0.0;
        }
    }
}

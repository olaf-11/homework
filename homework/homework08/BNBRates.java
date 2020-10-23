/*
 * Олег Макиевский (группа MK-JC1-50-20)
 * г. Минск, 2020
 *
 * Задание SiteLoader. (Тема: indexOf, Exception)
 * !!!Внимание!!! при подключение к сайту, особенно НАЦБАНКА, может быть ошибка,
 * это не ваша вина это может быть проблема с сайтом, скоростью его ответа или
 * с недоступностью интернета.
 *
 * 2. В классе NBRBLoader требуется дописать метод handle.
 *    При помощи данного метода в строке content вы дожны найти курс валюты
 *    имя которой передали в параметре currencyName. Почти обычный поиск строки currencyName
 *    по строке content (нельзя использовать регулярные выражения).
 *
 * 5. Реализовать сохранение полученного или полученных курсов в файл.
 *    При запуске программы дать возможно пользователю указывать путь к файлу для сохранения курса,
 *    иначе курс должен сохраняться рядом рядом с запускаемой программой.
 */
package homework08;

import homework08.core.CurrencyRateToFileWriter;
import homework08.core.NBRBLoader;
import homework08.core.SiteLoader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class BNBRates {
    public static void main(String[] args) {
        //Path for String[] args
        //homework/homework/homework08/BNBrates.txt

        SiteLoader loader = new NBRBLoader();

        CurrencyRateToFileWriter NBRBToFileWriter = new CurrencyRateToFileWriter("BNBrates.txt");
        NBRBToFileWriter.setPathToWrite(args);

        double rateEUR = loader.load(SiteLoader.Currency.EUR);
        System.out.println(rateEUR);
        NBRBToFileWriter.write(rateEUR,SiteLoader.Currency.EUR);

        double rateUSD = loader.load(SiteLoader.Currency.USD);
        System.out.println(rateUSD);
        NBRBToFileWriter.write(rateUSD,SiteLoader.Currency.USD);

        double rateRUB = loader.load(SiteLoader.Currency.RUB);
        System.out.println(rateRUB);
        NBRBToFileWriter.write(rateRUB,SiteLoader.Currency.RUB);
    }
}

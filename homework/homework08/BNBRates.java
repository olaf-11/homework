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

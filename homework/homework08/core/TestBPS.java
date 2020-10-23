package homework08.core;

public class TestBPS {
    public static void main(String[] args) {
        printRates(new BPSSbLoader());
    }

    public static void printRates(CommersSiteLoader loader){
        System.out.println(loader.load(CommersSiteLoader.Currency.EUR));
        System.out.println(loader.load(CommersSiteLoader.Currency.RUB));
        System.out.println(loader.load(CommersSiteLoader.Currency.USD));
    }
}

public class CurrencyConverterApp {
    public static void main(String[] args) {
        CurrencyApiClient apiClient = new CurrencyApiClient();
        CurrencyConverterService converterService = new CurrencyConverterService(apiClient);
        CurrencyConverter currencyConverter = new CurrencyConverter(converterService);

        currencyConverter.start();
    }
}

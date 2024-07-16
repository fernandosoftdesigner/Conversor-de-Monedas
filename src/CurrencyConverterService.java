import com.google.gson.JsonObject;

public class CurrencyConverterService {
    private CurrencyApiClient apiClient;

    public CurrencyConverterService(CurrencyApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public double convertCurrency(String from, String to, double amount) throws Exception {
        JsonObject rates = apiClient.getRates(from);
        double rate = rates.getAsJsonObject("rates").get(to).getAsDouble();
        return amount * rate;
    }
}

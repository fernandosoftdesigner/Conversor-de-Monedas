import java.io.StringReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class CurrencyApiClient {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public JsonObject getRates(String baseCurrency) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_URL + baseCurrency))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonReader reader = new JsonReader(new StringReader(response.body()));
        reader.setLenient(true);

        return JsonParser.parseReader(reader).getAsJsonObject();
    }
}

package ConversorDeMoedasApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonObject;



public class APIService {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private static final String[] CURRENCY_CODES = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

    public Map<String, Double> obterTaxasCambio() {
        Map<String, Double> taxasCambio = new HashMap<>();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri( URI.create(BASE_URL))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            for (String code : CURRENCY_CODES) {
                if (conversionRates.has(code)) {
                    taxasCambio.put(code, conversionRates.get(code).getAsDouble());
                    System.out.println("resposta da api"  + response.body());
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return taxasCambio;
    }

    public String[] getCurrencyCodes() {
        return CURRENCY_CODES;
    }
}
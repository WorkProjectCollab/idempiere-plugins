package in.tenthplanet.idempiere.currencyratesync.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;


public class CurrencyApi {
	public static void fetchCurrencyRate(String currency, String currencyTo, Timestamp date) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            if (date == null) {
            	HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://api.frankfurter.dev/v2/rate/"+currency+"/"+currencyTo))
                        .GET()
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Status Code: " + response.statusCode());
                System.out.println("Response: " + response.body());
                }
            else {
            	HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://api.frankfurter.dev/v2/rate/"+currency))
                        .GET()
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println("Status Code: " + response.statusCode());
                System.out.println("Response: " + response.body());
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

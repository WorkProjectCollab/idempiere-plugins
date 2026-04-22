package in.tenthplanet.idempiere.currencyratesync.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;



public class CurrencyApi {
	public ArrayList<CurrencyRate> fetchCurrencyRate(String currency, String currencyTo, Timestamp dateTime, Timestamp dateTimeTo) {
		
		ArrayList<CurrencyRate> rates = null;
		LocalDate date = dateTime != null ? dateTime.toLocalDateTime().toLocalDate(): null;
		LocalDate dateTo = dateTimeTo != null ? dateTimeTo.toLocalDateTime().toLocalDate(): null;

            if (date != null && dateTo == null) {
            	rates = makeRequest("https://api.frankfurter.dev/v2/rate/"+currency+"/"+currencyTo+"?date="+date);

                }
            else if(date != null && dateTo != null) {
            	rates = makeRequest("https://api.frankfurter.dev/v2/rates?base="+currency+"&quotes="+currencyTo+"&from="+date+"&to="+dateTo);
            	
                }
            else {
            	rates = makeRequest("https://api.frankfurter.dev/v2/rate/"+currency+"/"+currencyTo);
            	}
            return rates;
            
    }
	
	public ArrayList<CurrencyRate> makeRequest(String url) {
		
		ArrayList<CurrencyRate> rateList = new ArrayList<>();
		
		try {
        HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        ObjectMapper mapper = new ObjectMapper();
        rateList = mapper.readValue(response.body(), new TypeReference<ArrayList<CurrencyRate>>() {});
        
                
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rateList;
		
	}

}

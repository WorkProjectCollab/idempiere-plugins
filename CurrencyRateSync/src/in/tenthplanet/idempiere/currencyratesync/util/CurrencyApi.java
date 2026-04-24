package in.tenthplanet.idempiere.currencyratesync.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.ArrayList;
import java.util.List;


public class CurrencyApi {
	public List<CurrencyRate> fetchCurrencyRate(String currency, String currencyTo, Timestamp dateTime, Timestamp dateTimeTo) {
		
		List<CurrencyRate> rates = null;
		LocalDate date = dateTime != null ? dateTime.toLocalDateTime().toLocalDate(): null;
		LocalDate dateTo = dateTimeTo != null ? dateTimeTo.toLocalDateTime().toLocalDate(): null;
		
		if (dateTo != null && date != null && dateTo.isBefore(date)) {
			throw new IllegalArgumentException("To date cannot be before From date");
		}
		

            if (date != null && dateTo == null) {
            	rates = getResponse("https://api.frankfurter.dev/v2/rate/"+currency+"/"+currencyTo+"?date="+date);

                }	
            else if(date != null && dateTo != null) {
            	rates = getResponse("https://api.frankfurter.dev/v2/rates?base="+currency+"&quotes="+currencyTo+"&from="+date+"&to="+dateTo);
            	
                }
            else {
            	rates = getResponse("https://api.frankfurter.dev/v2/rate/"+currency+"/"+currencyTo);
            	}
            return rates;
            
    }
	
	public List<CurrencyRate> getResponse(String url) {
		
		List<CurrencyRate> rateList = new ArrayList<>();
		
		try {
        HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        
        String json = response.body();
        rateList = mapper.readValue(json, new TypeReference<List<CurrencyRate>>() {});
        
                
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rateList;
		
	}

}

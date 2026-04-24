package in.tenthplanet.idempiere.currencyratesync.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import java.util.List;
import in.tenthplanet.idempiere.currencyratesync.util.CurrencyApi;
import in.tenthplanet.idempiere.currencyratesync.util.CurrencyRate;

public class CurrencyApiTest {

    @Test
    void testFetchCurrencyRate() {
        String currency = "USD";
        String currencyTo = "INR";
        Timestamp timestamp = Timestamp.valueOf("2024-01-15 10:30:00");
        Timestamp timestampTo = Timestamp.valueOf("2024-01-16 10:30:00");
        Timestamp timestampnull = null;
        
        assertNotNull(timestamp);

        CurrencyApi CurrencyApiTest = new CurrencyApi();
        List<CurrencyRate> r1 = CurrencyApiTest.fetchCurrencyRate(currency, currencyTo, timestamp, timestampTo);
        List<CurrencyRate> r2 = CurrencyApiTest.fetchCurrencyRate(currency, currencyTo, timestamp, timestampnull);
        List<CurrencyRate> r3 = CurrencyApiTest.fetchCurrencyRate(currency, currencyTo, timestampnull, timestampnull);
        
        for (CurrencyRate rate : r1) {
            System.out.println(rate.getDate() + " - " + rate.getRate());
        }
        for (CurrencyRate rate : r2) {
            System.out.println(rate.getDate() + " - " + rate.getRate());
        }
        for (CurrencyRate rate : r3) {
            System.out.println(rate.getDate() + " - " + rate.getRate());
        }

    }
}
package in.tenthplanet.idempiere.currencyratesync.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Timestamp;
import in.tenthplanet.idempiere.currencyratesync.util.CurrencyApi;

public class CurrencyApiTest {

    @Test
    void testFetchCurrencyRate() {
        String currency = "USD";
        String currencyTo = "INR";
        Timestamp timestamp = Timestamp.valueOf("2024-01-15 10:30:00");
        Timestamp timestampTo = Timestamp.valueOf("2024-01-16 10:30:00");
        Timestamp timestampnull = null;
        
        assertNotNull(timestamp);

        // Call your plugin method
        CurrencyApi CurrencyApiTest = new CurrencyApi();
        CurrencyApiTest.fetchCurrencyRate(currency, currencyTo, timestamp, timestampTo);
        CurrencyApiTest.fetchCurrencyRate(currency, currencyTo, timestamp, timestampnull);
        CurrencyApiTest.fetchCurrencyRate(currency, currencyTo, timestampnull, timestampnull);

    }
}
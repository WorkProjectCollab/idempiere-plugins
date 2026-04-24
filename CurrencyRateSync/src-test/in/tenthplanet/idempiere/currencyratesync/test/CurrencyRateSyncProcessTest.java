package in.tenthplanet.idempiere.currencyratesync.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import in.tenthplanet.idempiere.currencyratesync.process.CurrencyRateSyncProcess;
import org.compiere.Adempiere;
import org.compiere.util.Env;
import org.junit.jupiter.api.BeforeEach;
import org.compiere.process.ProcessInfo;
import java.util.Properties;

public class CurrencyRateSyncProcessTest {
	
	private Properties ctx;

    @BeforeEach
    void setup() {
        Adempiere.startup(false);
        ctx = Env.getCtx();

        Env.setContext(ctx, "#AD_Client_ID", 1000000);
        Env.setContext(ctx, "#AD_Org_ID", 1000000);
        Env.setContext(ctx, "#AD_User_ID", 100);
    }

    @Test
    void testDoIt() throws Exception {

        CurrencyRateSyncProcess process = new CurrencyRateSyncProcess();

        ProcessInfo pi = new ProcessInfo("Test", 0);

        process.startProcess(ctx, pi, null);

        assertNotNull(pi);
    }


}

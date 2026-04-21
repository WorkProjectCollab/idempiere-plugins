package in.tenthplanet.idempiere.currencyratesync.process;

import org.compiere.process.SvrProcess;

public class CurrencySyncProcess extends SvrProcess {

    @Override
    protected void prepare() {
        System.out.println("CurrencySyncProcess — prepare() called");
    }

    @Override
    protected String doIt() throws Exception {
        System.out.println("CurrencySyncProcess — doIt() called!");
        return "Surya-CurrencyRateSync";
    }
}
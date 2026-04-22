package in.tenthplanet.idempiere.currencyratesync.process;

import org.adempiere.base.*;
import org.compiere.process.*;

public class CurrencyRateSyncProcessFactory implements IProcessFactory {

	@Override
    public ProcessCall newProcessInstance(String className) {
        if (className.equals(CurrencyRateSyncProcess.class.getName())) {
            return new CurrencyRateSyncProcess();
        }
        return null; // return null if classname doesn't match
    }
	
}

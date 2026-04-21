package in.tenthplanet.idempiere.currencyratesync.process;

import org.adempiere.base.*;
import org.compiere.process.*;

public class CurrencySyncProcessFactory implements IProcessFactory {

	@Override
    public ProcessCall newProcessInstance(String className) {
        if (className.equals(CurrencySyncProcess.class.getName())) {
            return new CurrencySyncProcess();
        }
        return null; // return null if classname doesn't match
    }
	
}

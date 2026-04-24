package in.tenthplanet.idempiere.currencyratesync.process;

import java.sql.Timestamp;
import java.util.logging.Level;

import org.compiere.model.MCurrency;
import org.compiere.model.MProcessPara;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import in.tenthplanet.idempiere.currencyratesync.util.CurrencyApi;

/**
 *	Currency Rate Sync Process
 *	
 *  @author Surya
 */
public class CurrencyRateSyncProcess extends SvrProcess {
	
	/**	Currency Rate Sync Parameter  */
	
	/**Currency					*/
	private int  		p_C_Currency_ID=0;
	/**Currency	To				*/
	private int  		p_C_Currency_ID_To=0;
	/**Date						*/
	private Timestamp   	p_Date;

	/**
	 *  Prepare - e.g., get Parameters.
	 */
    protected void prepare() {
        ProcessInfoParameter[] para = getParameter();
        for(int i = 0; i < para.length; i++) {
        	String name=para[i].getParameterName();
        	if(para[i].getParameter() == null && para[i].getParameter_To() == null)
    			;
        	else if(name.equals("C_Currency_ID"))
        		p_C_Currency_ID=para[i].getParameterAsInt();
        	else if(name.equals("C_Currency_ID_To"))
        		p_C_Currency_ID_To=para[i].getParameterAsInt();
        	else if(name.equals("DateAcct"))
        		p_Date=para[i].getParameterAsTimestamp();
        	else
        		MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), para[i]);
        }
        
    }

    /**
	 * 	Process
	 *	@return info
	 *	@throws Exception
	 */
    protected String doIt() throws Exception {
        String fromISO = MCurrency.getISO_Code(getCtx(), p_C_Currency_ID);
        String toISO = MCurrency.getISO_Code(getCtx(), p_C_Currency_ID_To);
        
        if(log.isLoggable(Level.INFO)) log.info("From=" + fromISO + ", To=" + toISO + ", Date=" + p_Date);
        
        
        return "Currency Rate Sync Completed";
    }
}
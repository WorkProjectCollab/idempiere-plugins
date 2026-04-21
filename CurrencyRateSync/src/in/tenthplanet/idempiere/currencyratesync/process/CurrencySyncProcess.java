package in.tenthplanet.idempiere.currencyratesync.process;

import org.compiere.model.MProcessPara;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import java.sql.Timestamp;

/**
 *	Currency Rate Sync Process
 *	
 *  @author Surya
 */
public class CurrencySyncProcess extends SvrProcess {
	
	/**	Currency Rate Sync Parameter  */
	
	/**Currency					*/
	private String  		p_C_Currency_ID=null;
	/**Currency	To				*/
	private String  		p_C_Currency_ID_To=null;
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
        		p_C_Currency_ID=para[i].getParameterAsString();
        	else if(name.equals("C_Currency_ID_To"))
        		p_C_Currency_ID_To=para[i].getParameterAsString();
        	else if(name.equals("Date"))
        		p_Date=para[i].getParameterAsTimestamp();
        	else
        		MProcessPara.validateUnknownParameter(getProcessInfo().getAD_Process_ID(), para[i]);
        }
        
    }

    @Override
    protected String doIt() throws Exception {
        System.out.println("CurrencySyncProcess — doIt() called!");
        return "Surya-CurrencyRateSync";
    }
}
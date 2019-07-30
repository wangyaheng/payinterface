package bean;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;




public class ProvisionsScheduleTrade implements Serializable {
	private ProvisionsScheduleBatch provisionsSchedulebatch;
	private List<ProvisionsScheduleBill> provisionsScheduleBillList;
	private Properties prop;
	/** 资金账户 */
	private FundAccountBean fundAccountBean;
	/** 本次操作类型：查询、付款交易、查询余额 **/
	private MessageType messageType;
	private Map params;
	/** 是否单笔 **/
	private RemitType remitType;

	/**
	 * @return the params
	 */
	public Map getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Map params) {
		this.params = params;
	}

	/**
	 * @return the remitType
	 */
	public RemitType getRemitType() {
		return remitType;
	}

	/**
	 * @param remitType the remitType to set
	 */
	public void setRemitType(RemitType remitType) {
		this.remitType = remitType;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public FundAccountBean getFundAccountBean() {
		return fundAccountBean;
	}

	public void setFundAccountBean(FundAccountBean fundAccountBean) {
		this.fundAccountBean = fundAccountBean;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public ProvisionsScheduleBatch getProvisionsSchedulebatch() {
		return provisionsSchedulebatch;
	}

	public void setProvisionsSchedulebatch(ProvisionsScheduleBatch provisionsSchedulebatch) {
		this.provisionsSchedulebatch = provisionsSchedulebatch;
	}

	public List<ProvisionsScheduleBill> getProvisionsScheduleBillList() {
		return provisionsScheduleBillList;
	}

	public void setProvisionsScheduleBillList(List<ProvisionsScheduleBill> provisionsScheduleBillList) {
		this.provisionsScheduleBillList = provisionsScheduleBillList;
	}

}
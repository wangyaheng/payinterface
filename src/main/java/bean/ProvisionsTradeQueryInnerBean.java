package bean;

public class ProvisionsTradeQueryInnerBean {
	
	private static final long serialVersionUID = -655491369973972413L;
	/**付款批次号*/
	private String batchCode;

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	@Override
	public String toString() {
		return "ProvisionsTradeQueryInnerBean [batchCode=" + batchCode + "]";
	}
}

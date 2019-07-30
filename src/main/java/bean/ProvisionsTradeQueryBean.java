package bean;
import java.io.Serializable;



/**
 * @Description: 付款查询Bean
 * @see: RemitQueryBean 此处填写需要参考的类
 * @version 2014年12月4日 下午3:27:12
 * @author yunqiang.song
 */
public class ProvisionsTradeQueryBean implements Serializable {

	private static final long serialVersionUID = 8266160031208231511L;

	/** 支付接口编号 */
	
	private String interfaceInfoCode;
	/** 批次号 */

	private String batchCode;

	public String getInterfaceInfoCode() {
		return interfaceInfoCode;
	}

	public void setInterfaceInfoCode(String interfaceInfoCode) {
		this.interfaceInfoCode = interfaceInfoCode;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	@Override
	public String toString() {
		return "RemitQueryBean [interfaceInfoCode=" + interfaceInfoCode + ", batchCode=" + batchCode + "]";
	}

}

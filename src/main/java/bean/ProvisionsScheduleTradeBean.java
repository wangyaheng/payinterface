package bean;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

public class ProvisionsScheduleTradeBean implements Serializable {
	private ProvisionsScheduleBatchBean provisionsSchedulebatch;
	private List<ProvisionsScheduleBill> provisionsScheduleBillList;
	private  Properties prop;


	
	public ProvisionsScheduleBatchBean getProvisionsSchedulebatch() {
		return provisionsSchedulebatch;
	}
	public void setProvisionsSchedulebatch(
			ProvisionsScheduleBatchBean provisionsSchedulebatch) {
		this.provisionsSchedulebatch = provisionsSchedulebatch;
	}
	public List<ProvisionsScheduleBill> getProvisionsScheduleBillList() {
		return provisionsScheduleBillList;
	}
	public void setProvisionsScheduleBillList(
			List<ProvisionsScheduleBill> provisionsScheduleBillList) {
		this.provisionsScheduleBillList = provisionsScheduleBillList;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
//	
//	private String _class;
//
//
//	public String getclass() {
//		return _class;
//	}
//	public void setclass(String _class) {
//		this._class = _class;
//	}
	
}

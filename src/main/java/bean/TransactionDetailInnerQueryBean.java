package bean;

import java.io.Serializable;
import java.util.Map;

public class TransactionDetailInnerQueryBean implements Serializable {
	
	private Map<String,Object> map;

	
	public Map<String, Object> getMap() {
		return map;
	}


	public void setMap(Map<String, Object> map) {
		this.map = map;
	}


	@Override
	public String toString() {
		return "TransactionDetailInnerQueryBean [map=" + map + "]";
	}
	
	
}

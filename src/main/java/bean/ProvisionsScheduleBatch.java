package bean;



import java.util.Date;




/**
 *
 * @Description: 资金调拨批次
 * @see: ReserveFundScheduleBatch 此处填写需要参考的类
 * @version 2016年2月15日 上午9:56:36
 * @author jingyuan.ma
 */

public class ProvisionsScheduleBatch {
	/**通道编号*/
	private String passageWayCode;
	/** 批次号 */
	private String batchCode;
	/** 总笔数 */
	private int totalNumber;
	/** 总金额 */
	private double totalAmount;
	/** 批次状态 */
	private ProvisionsTradeStatus status;
	/**付款文件名称**/
	private String fileName;
	/** 付款文件下载路径 */
	private String downloadPath;
	/** 付款批次处理日期 */
	private Date batchHandleDate;
	/** 付款批次处理完成日期 */
	private Date batchHandleFinishDate;
	
	public String getPassageWayCode() {
		return passageWayCode;
	}
	public void setPassageWayCode(String passageWayCode) {
		this.passageWayCode = passageWayCode;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public ProvisionsTradeStatus getStatus() {
		return status;
	}
	public void setStatus(ProvisionsTradeStatus status) {
		this.status = status;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	public Date getBatchHandleDate() {
		return batchHandleDate;
	}
	public void setBatchHandleDate(Date batchHandleDate) {
		this.batchHandleDate = batchHandleDate;
	}
	public Date getBatchHandleFinishDate() {
		return batchHandleFinishDate;
	}
	public void setBatchHandleFinishDate(Date batchHandleFinishDate) {
		this.batchHandleFinishDate = batchHandleFinishDate;
	}


}

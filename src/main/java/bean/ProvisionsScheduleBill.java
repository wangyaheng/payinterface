package bean;

import java.io.Serializable;

/**
 *
 * @Description:资金调拨单
 * @see: ReserveFundScheduleBill 用于备付金调拨
 * @version 2016年2月14日 下午5:45:13
 * @author jingyuan.ma
 */

public class ProvisionsScheduleBill implements Serializable{
	/** 付款批次号 */
	private String batchCode;
	/** 付款单号 */
	private String billCode;
	private String payeraccount;             //备付金账户账号
	private String payerAcctName;            //备付金账户户名
	private String payerAccountType;   			 //备付金账户类型
	private String pathCode;                 //汇路
	private Double amount;                   //交易金额
	private String payeeAcctName;            //收款账户户名
	private String payeeaccount;             //收款账户账号
	private String payeeAcctBranchName;      //收款人开户行名
	private String payeeacctBankid;          //收款人开户行号
	private String purpose;                  //用途
	private String puposeDesc;			//用途描述
	private String busitype;                 //业务类型
	private String detail;                   //附言
	private String flag;				//本他行标志位
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getBatchCode() {
		return batchCode;
	}
	@Override
	public String toString() {
		return "ProvisionsScheduleBill [batchCode=" + batchCode + ", billCode="
				+ billCode + ", payeraccount=" + payeraccount
				+ ", payerAcctName=" + payerAcctName + ", payerAccountType="
				+ payerAccountType + ", pathCode=" + pathCode + ", amount="
				+ amount + ", payeeAcctName=" + payeeAcctName
				+ ", payeeaccount=" + payeeaccount + ", payeeAcctBranchName="
				+ payeeAcctBranchName + ", payeeacctBankid=" + payeeacctBankid
				+ ", purpose=" + purpose + ", puposeDesc=" + puposeDesc
				+ ", busitype=" + busitype + ", detail=" + detail + ", flag="
				+ flag + "]";
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getPayeraccount() {
		return payeraccount;
	}
	public void setPayeraccount(String payeraccount) {
		this.payeraccount = payeraccount;
	}
	public String getPayerAcctName() {
		return payerAcctName;
	}
	public void setPayerAcctName(String payerAcctName) {
		this.payerAcctName = payerAcctName;
	}
	public String getPayerAccountType() {
		return payerAccountType;
	}
	public void setPayerAccountType(String payerAccountType) {
		this.payerAccountType = payerAccountType;
	}
	public String getPathCode() {
		return pathCode;
	}
	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPayeeAcctName() {
		return payeeAcctName;
	}
	public void setPayeeAcctName(String payeeAcctName) {
		this.payeeAcctName = payeeAcctName;
	}
	public String getPayeeaccount() {
		return payeeaccount;
	}
	public void setPayeeaccount(String payeeaccount) {
		this.payeeaccount = payeeaccount;
	}
	public String getPayeeAcctBranchName() {
		return payeeAcctBranchName;
	}
	public void setPayeeAcctBranchName(String payeeAcctBranchName) {
		this.payeeAcctBranchName = payeeAcctBranchName;
	}
	public String getPayeeacctBankid() {
		return payeeacctBankid;
	}
	public void setPayeeacctBankid(String payeeacctBankid) {
		this.payeeacctBankid = payeeacctBankid;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getBusitype() {
		return busitype;
	}
	public void setBusitype(String busitype) {
		this.busitype = busitype;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPuposeDesc() {
		return puposeDesc;
	}
	public void setPuposeDesc(String puposeDesc) {
		this.puposeDesc = puposeDesc;
	}

}

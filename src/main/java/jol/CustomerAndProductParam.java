package jol;

import java.io.Serializable;
import java.util.Date;

public class CustomerAndProductParam implements Serializable{

	private static final long serialVersionUID = 1L;
	private double creditCardRate;
	private double debitCardRate;
	private String productTemplateCode;
	private String customerNo;
	private Date effectTime;
	private Date expireTime;




	public Date getEffectTime() {
		return effectTime;
	}
	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public double getCreditCardRate() {
		return creditCardRate;
	}
	public void setCreditCardRate(double creditCardRate) {
		this.creditCardRate = creditCardRate;
	}
	public double getDebitCardRate() {
		return debitCardRate;
	}
	public void setDebitCardRate(double debitCardRate) {
		this.debitCardRate = debitCardRate;
	}
	public String getProductTemplateCode() {
		return productTemplateCode;
	}
	public void setProductTemplateCode(String productTemplateCode) {
		this.productTemplateCode = productTemplateCode;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	@Override
	public String toString() {
		return "CustomerAndProductParam [creditCardRate=" + creditCardRate + ", debitCardRate=" + debitCardRate + ", productTemplateCode=" + productTemplateCode
				+ ", customerNo=" + customerNo + ", effectTime=" + effectTime + ", expireTime=" + expireTime + "]";
	}



}

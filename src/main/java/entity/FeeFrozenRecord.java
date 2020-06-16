package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class FeeFrozenRecord implements Serializable {
	private static final long serialVersionUID = -1;
	private String id;

	private String frozenRecordCode;

	private String consumerNo;

	private String promotionCode;

	private String terminalCode;

	/** 开始冻结时间 */
	private Date frozenStartTime;

	/** 冻结完成时间 */
	private Date frozenCompleteTime;
	/** 用户活动结束时间 */
	private Date customerEndTime;

	/** 应该冻结金额 */
	private BigDecimal planFrozenAmount;

	/** 冻结金额 */
	private BigDecimal frozenAmount;

	/** 状态：冻结中，已冻结，已取消 */
	private String recordStatus;

	/** 创建时间 */
	private Date createTime;

	/** 编辑时间 */
	private Date editTime;

	/** 冻结流水号，来自账务系统 */
	private String frozenSerialNo;

	/** 版本号 */
	private Integer version;

	/** 优先级 */
	private Integer priority;

	/** 服务费订单号 */
	private String feeNo;

	/** 服务商编号 */
	private String agentNo;

	/** 一级代理商编号 */
	private String firstAgentNo;

	/**品牌号*/
	private String brandCode;

	private String orderNo;

	private String bankExternalId;







	public String getBankExternalId() {
		return bankExternalId;
	}

	public void setBankExternalId(String bankExternalId) {
		this.bankExternalId = bankExternalId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getFirstAgentNo() {
		return firstAgentNo;
	}

	public void setFirstAgentNo(String firstAgentNo) {
		this.firstAgentNo = firstAgentNo;
	}

	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * @return the customerEndTime
	 */
	public Date getCustomerEndTime() {
		return customerEndTime;
	}

	/**
	 * @param customerEndTime the customerEndTime to set
	 */
	public void setCustomerEndTime(Date customerEndTime) {
		this.customerEndTime = customerEndTime;
	}

	public String getFrozenRecordCode() {
		return frozenRecordCode;
	}

	public void setFrozenRecordCode(String frozenRecordCode) {
		this.frozenRecordCode = frozenRecordCode == null ? null : frozenRecordCode.trim();
	}

	public String getConsumerNo() {
		return consumerNo;
	}

	public void setConsumerNo(String consumerNo) {
		this.consumerNo = consumerNo == null ? null : consumerNo.trim();
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode == null ? null : promotionCode.trim();
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode == null ? null : terminalCode.trim();
	}

	public Date getFrozenStartTime() {
		return frozenStartTime;
	}

	public void setFrozenStartTime(Date frozenStartTime) {
		this.frozenStartTime = frozenStartTime;
	}

	public Date getFrozenCompleteTime() {
		return frozenCompleteTime;
	}

	public void setFrozenCompleteTime(Date frozenCompleteTime) {
		this.frozenCompleteTime = frozenCompleteTime;
	}

	public BigDecimal getPlanFrozenAmount() {
		return planFrozenAmount;
	}

	public void setPlanFrozenAmount(BigDecimal planFrozenAmount) {
		this.planFrozenAmount = planFrozenAmount;
	}

	public BigDecimal getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(BigDecimal frozenAmount) {
		this.frozenAmount = frozenAmount;
	}

	/**
	 * @return the recordStatus
	 */
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @param recordStatus the recordStatus to set
	 */

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getFrozenSerialNo() {
		return frozenSerialNo;
	}

	public void setFrozenSerialNo(String frozenSerialNo) {
		this.frozenSerialNo = frozenSerialNo == null ? null : frozenSerialNo.trim();
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getFeeNo() {
		return feeNo;
	}

	public void setFeeNo(String feeNo) {
		this.feeNo = feeNo == null ? null : feeNo.trim();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeeFrozenRecord [id=" + id + ", frozenRecordCode=" + frozenRecordCode + ", consumerNo=" + consumerNo + ", promotionCode=" + promotionCode
				+ ", terminalCode=" + terminalCode + ", frozenStartTime=" + frozenStartTime + ", frozenCompleteTime=" + frozenCompleteTime + ", customerEndTime="
				+ customerEndTime + ", planFrozenAmount=" + planFrozenAmount + ", frozenAmount=" + frozenAmount + ", recordStatus=" + recordStatus + ", createTime="
				+ createTime + ", editTime=" + editTime + ", frozenSerialNo=" + frozenSerialNo + ", version=" + version + ", priority=" + priority + ", feeNo="
				+ feeNo + "]";
	}

}
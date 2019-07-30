package bean;



public enum ProvisionsTradeStatus {
	/** 未知 */
	UNKNOWN,
	/**已发送**/
	SENT,
	/** 成功 */
	SUCCESS,
	/** 失败待确认 */
	CONFIRM,
	/** 失败 */
	FAILED,
	/** 关闭 */
	CLOSED,
	/**作废**/
	ABANDONED;
}

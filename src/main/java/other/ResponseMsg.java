package other;
public class ResponseMsg {
  private String responseCode;
  private String responseMsg;
  private String requestCode;
  private String tradeOrderCode;
  public String getResponseCode() {
    return responseCode;
  }
  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }
  public String getResponseMsg() {
    return responseMsg;
  }
  public void setResponseMsg(String responseMsg) {
    this.responseMsg = responseMsg;
  }
  public String getRequestCode() {
    return requestCode;
  }
  public void setRequestCode(String requestCode) {
    this.requestCode = requestCode;
  }
  public String getTradeOrderCode() {
    return tradeOrderCode;
  }
  public void setTradeOrderCode(String tradeOrderCode) {
    this.tradeOrderCode = tradeOrderCode;
  }
  @Override
  public String toString() {
    return "ResponseMsg [responseCode=" + responseCode + ", responseMsg="
        + responseMsg + ", requestCode=" + requestCode
        + ", tradeOrderCode=" + tradeOrderCode + "]";
  }
  
  
}
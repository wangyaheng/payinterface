package netty.netty3;


import java.util.Map;

public class Message {
    // 魔数，固定的值代表是当前协议
    private int magicNum;
    //主版本号
    private byte mainVersion;
    // 次版本号
    private byte subVersion;
    // 修改版本号
    private byte modifyVersion;

    private String sessionId;

    private MessageType messageType;
    private Map<String,String> attachments;
    private String body;

    public int getMagicNum() {
        return magicNum;
    }

    public void setMagicNum(int magicNum) {
        this.magicNum = magicNum;
    }

    public byte getMainVersion() {
        return mainVersion;
    }

    public void setMainVersion(byte mainVersion) {
        this.mainVersion = mainVersion;
    }

    public byte getSubVersion() {
        return subVersion;
    }

    public void setSubVersion(byte subVersion) {
        this.subVersion = subVersion;
    }

    public byte getModifyVersion() {
        return modifyVersion;
    }

    public void setModifyVersion(byte modifyVersion) {
        this.modifyVersion = modifyVersion;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, String> attachments) {
        this.attachments = attachments;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "magicNum=" + magicNum +
                ", mainVersion=" + mainVersion +
                ", subVersion=" + subVersion +
                ", modifyVersion=" + modifyVersion +
                ", sessionId='" + sessionId + '\'' +
                ", messageType=" + messageType +
                ", attachments=" + attachments +
                ", body='" + body + '\'' +
                '}';
    }
}

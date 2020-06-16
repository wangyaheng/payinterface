package netty.dubbo.bean;

import netty.netty3.Client;

import java.util.concurrent.atomic.AtomicLong;

public class ClientRequest {

    // 请求命令
    private String command = "test";
    // 请求内容
    private Object content;

    private final long id;

    private static final AtomicLong al = new AtomicLong(0);

    public ClientRequest(){
        // 请求id每次都自增1
        id = al.incrementAndGet();
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public static AtomicLong getAl() {
        return al;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "command='" + command + '\'' +
                ", content=" + content +
                ", id=" + id +
                '}';
    }
}

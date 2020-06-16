package netty.netty3;

import javafx.scene.input.InputMethodTextRun;

import java.util.ArrayList;
import java.util.List;

public class MessageResolverFactory {

    private static final MessageResolverFactory MESSAGE_RESOLVER_FACTORY = new MessageResolverFactory();
    private static final List<Resolve> list = new ArrayList<>();

    public static MessageResolverFactory getInstance(){
        return MESSAGE_RESOLVER_FACTORY;
    }
    public void registResolve(Resolve resolve){
        list.add(resolve);
    }
    public Resolve getResolve(MessageType messageType){
        for (Resolve resolver : list) {
            if(resolver.support(messageType)){
                return resolver;
            }
        }
        return null;
    }
}

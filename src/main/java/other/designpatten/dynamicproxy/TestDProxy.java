package other.designpatten.dynamicproxy;


import java.lang.reflect.Proxy;

public class TestDProxy {
    public static void main(String[] args) {
        Dao o =(Dao)Proxy.newProxyInstance(TestDProxy.class.getClassLoader(), new Class[]{Dao.class}, new DaoInvocationHandler());
        o.login("aaaa");

    }

}

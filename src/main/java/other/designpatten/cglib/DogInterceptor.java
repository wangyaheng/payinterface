package other.designpatten.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DogInterceptor implements MethodInterceptor {



    /**
     *
     * @param o cglib生成的动态代理类
     * @param method 被代理的方法的method实例
     * @param params 方法的参数
     * @param methodProxy 用于调用父类真正的业务类方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        System.out.println("proxy before=========");
        Object invoke = methodProxy.invokeSuper(o,params);
        System.out.println("proxy after=========");
        return invoke;
    }

}

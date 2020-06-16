package introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Introspector.getBeanInfo 获取类的各种信息
 */
public class TestIntrospector {
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
            System.out.println(beanInfo);
            for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
                System.out.println(propertyDescriptor.getWriteMethod());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

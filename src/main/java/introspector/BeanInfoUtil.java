package introspector;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * java内省机制
 * 1. getPropertyType()，获得属性的Class对象;
 　　2. getReadMethod()，获得用于读取属性值的方法；getWriteMethod()，获得用于写入属性值的方法;
 　　3. hashCode()，获取对象的哈希值;
 　　4. setReadMethod(Method readMethod)，设置用于读取属性值的方法;
 　　5. setWriteMethod(Method writeMethod)，设置用于写入属性值的方法。
 */
public class BeanInfoUtil {

    public static void main(String[] args) {
        PropertyDescriptor propDesc = null;
        UserInfo userInfo = new UserInfo();
        try {
            propDesc = new PropertyDescriptor("userName", UserInfo.class);
            Method writeMethod = propDesc.getWriteMethod();
            writeMethod.invoke(userInfo,"aaa");
            System.out.println(userInfo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(propDesc);
    }

}

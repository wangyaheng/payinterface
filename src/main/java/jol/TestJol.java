package jol;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;


import java.util.Comparator;
import java.util.Date;

/**
 * jol instance detial
 */
public class TestJol {
    static A a = new A();

    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        A a = b.a;
        a.flag=true;
        CustomerAndProductParam customerAndProductParam = new CustomerAndProductParam();
        customerAndProductParam.setCreditCardRate(0.06d);
        customerAndProductParam.setCustomerNo("23452345");
        customerAndProductParam.setDebitCardRate(0.06d);
        customerAndProductParam.setEffectTime(new Date());
        customerAndProductParam.setExpireTime(new Date());
        customerAndProductParam.setProductTemplateCode("wertwe354234523445");


        Comparator<A> comparator = (A a1,A a2)-> Boolean.compare(a1.flag,a2.flag);

        TestJol.a.flag=true;
        A clone = (A) TestJol.a.clone();
        System.out.println(clone.flag);

        String str = "861234567";
        System.out.println(VM.current().details());//
        System.out.println(ClassLayout.parseInstance(customerAndProductParam).toPrintable());// 打印对象的详细信息（对象头，对象的大小等信息）
        System.out.println(ClassLayout.parseInstance(str).toPrintable());// 打印对象的详细信息（对象头，对象的大小等信息）

    }
}

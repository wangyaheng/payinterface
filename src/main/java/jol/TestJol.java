package jol;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;


import java.util.Comparator;

/**
 * jol instance detial
 */
public class TestJol {
    static A a = new A();

    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        A a = b.a;
        a.flag=true;


        Comparator<A> comparator = (A a1,A a2)-> Boolean.compare(a1.flag,a2.flag);

        TestJol.a.flag=true;
        A clone = (A) TestJol.a.clone();
        System.out.println(clone.flag);


        System.out.println(VM.current().details());//
        System.out.println(ClassLayout.parseInstance(TestJol.a).toPrintable());// 打印对象的详细信息（对象头，对象的大小等信息）
    }
}

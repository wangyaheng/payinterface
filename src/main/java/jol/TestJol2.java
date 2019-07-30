package jol;

import org.openjdk.jol.info.ClassLayout;

public class TestJol2 {
    static A a  = new A();
    public static void main(String[] args) {
        a.hashCode();
      //  System.out.println(ClassLayout.parseInstance(a).toPrintable());
        new Thread(()->{
            sysc();

        }).start();

       // System.out.println(ClassLayout.parseInstance(a).toPrintable());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sysc();

    }

    public static void sysc(){
        synchronized (a){
            System.out.println("aaaaaa");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }
}

package jol;
import org.openjdk.jol.info.ClassLayout;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * sync 批量重偏向
 */
public class TestJol3 {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);//睡眠5秒可以使偏向锁开启（jdk默认延迟4秒开启偏向锁）


        List<A> list = new LinkedList<>();
        for (int i=0;i<50;i++){
            A a = new A();
            if(i==33)System.out.println("默认是偏向锁开始状态不偏向任何线程101"+ ClassLayout.parseInstance(a).toPrintable());
            list.add(a);
            synchronized (a){
                if(i==33) System.out.println("偏向锁偏向线程1------"+ClassLayout.parseInstance(a).toPrintable());


            }
        }
       new Thread(()->{
           // 开启线程2 使用上面的锁对象
           for (int i=0;i<50;i++){
             synchronized (list.get(i)){
                 if(i==13) System.out.println("升级为轻量级锁------"+ClassLayout.parseInstance(list.get(i)).toPrintable());
                 if(i==19){
                     System.out.println("批量重偏向------"+ClassLayout.parseInstance(list.get(i)).toPrintable());
                     System.out.println("------"+ClassLayout.parseInstance(list.get(8)).toPrintable());
                 }
             }
           }
       }).start();



    }
}

package classload;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.junit.Test;

import java.io.File;

public class MyApplication {

    public static String rootPath;
    public static void main(String[] args) {
        MyApplication myApplication = new MyApplication();
        System.out.println(MyApplication.class.getClassLoader());

        System.out.println(Test1.class.getClassLoader());
        run();
    }

    public static void run(){
        // 用自己的类加载器启动
        String rootPath = MyClassLoad.class.getResource("/").getPath().replaceAll("%20"," ");
        System.out.println(rootPath);

        rootPath = new File(rootPath).getPath();
        System.out.println(rootPath);
        MyApplication.rootPath = rootPath;
        MyClassLoad myClassLoad = new MyClassLoad(rootPath,rootPath+"/classload");
        try {
            startFileListener(rootPath+"/classload");
            start0(myClassLoad);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    public static void start0(MyClassLoad classLoader) throws Exception {

        Class<?> aClass = classLoader.loadClass("classload.MyApplication");

        aClass.getMethod("start").invoke(aClass.newInstance());

    }
    //新的classload
    public static void start(){
        System.out.println("启动我们的应用程序");
        System.out.println(MyApplication.class.getClassLoader());
        System.out.println(Test1.class.getClassLoader().getParent());
        //Tomcat tomcat = new Tomcat();
        //Controller ...xxxx
        new Test1().test();
    }
    /**
     * 监听文件变化
     * @param path
     * @throws Exception
     */
    public static void startFileListener(String path) throws Exception {
        FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(path);
        fileAlterationObserver.addListener(new FileListener());
        // 扫描的时间间隔
        FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor(5000);
        fileAlterationMonitor.addObserver(fileAlterationObserver);
        fileAlterationMonitor.start();

    }
}

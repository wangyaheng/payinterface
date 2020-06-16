package classload;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 目的是让由此类加载器加载的类查找缓存是永远都可以查到
 */
public class MyClassLoad extends ClassLoader{
    // 项目的根目录
    private String rootPath;

    private List<String> clazzs;

    public MyClassLoad(String rootPath,String...classpaths){
        this.rootPath = rootPath;
        this.clazzs = new ArrayList<>();
        for (String classpath : classpaths) {
            try {
                scanClassPath(new File(classpath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重写父类的loadClass方法
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        Class<?> loadedClass = findLoadedClass(name);
        if(loadedClass==null){
            // 判断是不是需要有此类加载器加载
            if(!clazzs.contains(name)){
                // 交给系统类加载器加载
                loadedClass =  getSystemClassLoader().loadClass(name);
            }else{
                throw new ClassNotFoundException("没有加载到类");
            }
        }
        return loadedClass;

    }

    private void scanClassPath(File file) throws Exception {
        if(file.isDirectory()){
            // 如果是文件夹就递归解析文件夹中的文件
            for (File file1 : file.listFiles()) {
                scanClassPath(file1);
            }
        }else{
            String name = file.getName();
            String path = file.getPath();
            String endName = name.substring(name.lastIndexOf(".") + 1);
            if("class".equals(endName)){
                // 是一个class文件
                //现在我们加载到的是一个Class文件
                //如何吧一个Class文件 加载成一个Class对象？？？？
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                String className = fileNameToClassName(path);
                // 将class加载到jvm中
                defineClass(className,bytes ,0 ,bytes.length);
                clazzs.add(className);

            }
        }

    }

    public  String fileNameToClassName(String filePath){
        //d: //project//com//luban//xxxx
        String className = filePath.replace(rootPath,"").replaceAll("\\\\",".");
//        com.luban.className.class
        className  =  className.substring(1,className.lastIndexOf("."));
        return className;
        //com.luban.classNamexxxx
    }


}

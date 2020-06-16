package jvm;

import leetcode.Q1;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 类加载器的命名空间：该加载器以及其父类加载器所加载的类组成
 *
 */
public class ClassLoadTets {

    public static void main(String[] args) {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //ExtClassLoader extends URLClassLoader
        final URLClassLoader parent = (URLClassLoader)systemClassLoader.getParent();
        // 查看扩展类加载器加载jar包的路径
        URL[] urLs = parent.getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }
        System.out.println(systemClassLoader);
        System.out.println(Q1.class.getClassLoader());
    }
}

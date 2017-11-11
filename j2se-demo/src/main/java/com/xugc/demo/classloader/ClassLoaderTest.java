package com.xugc.demo.classloader;

import java.net.URL;

/**
 * Created by xuguocheng on 2017/7/29.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        printBootstrapClassloader();
        System.out.println("********************");
        printExtClassLoader();
        System.out.println("********************");
        printSystemClassLoader();
    }

    /**
     * 打印启动类加载器,加载的java核心类的路径
     */
    public static void printBootstrapClassloader() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }

    /**
     * 扩展类加载器
     */
    public static void printExtClassLoader() {
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    public static void printSystemClassLoader() {
        System.out.println("ClassLoader.getSystemClassLoader().getParent():" + ClassLoader.getSystemClassLoader().getParent());
        System.out.println("ClassLoader.getSystemClassLoader().getParent().getParent():" + ClassLoader.getSystemClassLoader().getParent().getParent());
    }


}

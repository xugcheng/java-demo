package com.xugc.demo.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by xuguocheng on 2017/7/6.
 */
public class ExceptionUtil {


    public static String stackTrace(Throwable ex) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos);
        ex.printStackTrace(printStream);
        return bos.toString();
    }

    public static void main(String[] args) {
        Exception ex = new Exception("my exception");
        String stackStrace = ExceptionUtil.stackTrace(ex);
        System.out.println(stackStrace);
    }
}

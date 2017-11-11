import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xuguocheng on 2016/12/9.
 */
public class CountTest {

    public static final OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {

        //testUnsafeCount();

        testSafeCount();

    }

    public static void testUnsafeCount() {
        // 开始10个线程,每个线程调用100次基数接口,检查并发同步情况.
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int fi = i;
            exec.execute(new Runnable() {
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        String res = unsafeCount();
                        Thread.yield();
                        System.out.println("i:" + fi + ",j:" + j + ",res:" + res);
                    }
                }
            });
        }
    }

    public static void testSafeCount() {
        // 开始10个线程,每个线程调用100次基数接口,检查并发同步情况.
        ExecutorService exec1 = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int fi = i;
            exec1.execute(new Runnable() {
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        String res = safeCount();
                        Thread.yield();
                        System.out.println("i:" + fi + ",j:" + j + ",res:" + res);
                    }
                }
            });
        }
    }

    public static String unsafeCount() {
        Request request = new Request.Builder()
                .url("http://localhost:8080/count/unsafe")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String safeCount() {
        Request request = new Request.Builder()
                .url("http://localhost:8080/count/safe")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


}

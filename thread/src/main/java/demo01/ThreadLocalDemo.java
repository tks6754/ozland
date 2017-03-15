package demo01;

import java.util.concurrent.TimeUnit;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class ThreadLocalDemo implements Runnable {
    private ThreadLocal threadLocal = new ThreadLocal();

    public void run() {
        threadLocal.set(Math.random()*100);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadLocal.get());
    }
}

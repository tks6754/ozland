package demo02;

import java.util.concurrent.TimeUnit;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class Main {

    public static void main(String[] args) {
        FileClock fileClock = new FileClock();
        Thread thread = new Thread(fileClock);

        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        thread.start();


    }
}

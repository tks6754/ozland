package demo02;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class FileClock implements Runnable {
    public void run() {
        for (int i=0; i<10; i++){
            System.out.printf("%s \n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                System.out.println("The FileClock has been interrupted");
            }
        }
    }
}

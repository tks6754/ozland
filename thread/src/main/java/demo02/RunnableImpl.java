package demo02;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class RunnableImpl implements Runnable {
    public void run() {
        try {
            System.out.println("Begin sleep");
            //Thread.sleep(1000);
            Thread.sleep(6000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

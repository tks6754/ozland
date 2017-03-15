package demo02;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class TestRunnableImpl {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableImpl());
        thread.start();

        try {
            thread.join(1000);
            System.out.println("join finish");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

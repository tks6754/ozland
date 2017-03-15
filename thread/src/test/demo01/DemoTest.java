package demo01;

import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * Created by MiaoMU on 2017/3/12.
 */
public class DemoTest {

    @org.junit.Test
    public void demo01Test(){
        for (int i=10; i<10; i++){
            Calculator c = new Calculator(i);
            Thread thread = new Thread(c);
            thread.start();
        }
    }


    @Test
    public void testMyThread(){
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @Test
    public void testMyRunnable(){
        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();
    }

    @Test
    public void testMyRunnable2(){
        Thread myRun = new Thread(new MyRunnable(), "myRun");
        myRun.start();

        System.out.println(myRun.getName());
        System.out.println(Thread.currentThread().getName());
    }

}

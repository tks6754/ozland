package demo03.demo002;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by MiaoMU on 2017/3/14.
 */
public class LockThread implements Runnable {
    private Integer key = 0;

    private Lock lock = new ReentrantLock();

    public void run() {

        lock.lock();
        try {
            key++;

            System.out.println(Thread.currentThread().getName() + ":" + key);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }finally{
            // 上述代码实现功能与使用sychronized同步代码块一样。
            // sychronized同步代码块或同步方法在代码执行完之后锁自动释放；而用Lock则需要手工释放锁。
            // 为了保证锁最终被释放，释放锁代码放在finally块内。
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockThread lockThread = new LockThread();

        for (int i=0; i<10; i++){
            new Thread(lockThread).start();
        }
    }
}

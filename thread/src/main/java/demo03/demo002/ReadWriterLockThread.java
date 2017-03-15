package demo03.demo002;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by MiaoMU on 2017/3/14.
 */
public class ReadWriterLockThread implements Runnable {
    // 数据存放
    private StringBuilder sb = new StringBuilder();


    // 锁对象
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public void run() {
        if (Thread.currentThread().getName().startsWith("Read")) {
            rwl.readLock().lock();// 取到读锁
            try {
                System.out.println(Thread.currentThread().getName() + "正在读取...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "结果:" + sb.toString());
            } finally {
                rwl.readLock().unlock();// 释放读锁
            }
        } else if (Thread.currentThread().getName().startsWith("Write")) {
            rwl.writeLock().lock();// 取到写锁
            try {
                System.out.println(Thread.currentThread().getName() + "正在写入...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String writeData = "" + new Random().nextInt(100);
                sb.append(writeData + ",");

                System.out.println(Thread.currentThread().getName() + "结果:" + writeData);
            } finally {
                rwl.writeLock().unlock();// 释放写锁
            }
        } else {
            // 啥也不做行不
        }
    }

    public static void main(String[] args) {
        ReadWriterLockThread rwlt = new ReadWriterLockThread();
        for (int i=0; i<5; i++) {
            Thread t = new Thread(rwlt, "Write" + i);
            t.start();
        }
        for (int i=0; i<5; i++) {
            Thread t = new Thread(rwlt, "Read" + i);
            t.start();
        }
    }
}

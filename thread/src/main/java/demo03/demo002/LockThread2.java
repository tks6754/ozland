package demo03.demo002;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by MiaoMU on 2017/3/14.
 */
public class LockThread2 implements Runnable {
    // 内部类
    class Student {
        private int age = 0;
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    // 全局变量定义
    private int count = 0;
    private Student student = new Student();

    // 锁对象
    private Lock lock1 = new ReentrantLock(false);
    private Lock lock2 = new ReentrantLock(false);

    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running!");

        lock1.lock();// 使用重入锁
        System.out.println(currentThreadName + " got lock1@Step1!");
        try {
            count++;
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThreadName + " first:count=" + count + "\tage=" + this.student.getAge());
            lock1.unlock();
        }


        lock2.lock();// 使用另外一个不同的重入锁
        System.out.println(currentThreadName + " got lock2@Step2!");
        try {
            Random random = new Random();
            int age = random.nextInt(100);
            this.student.setAge(age);
            Thread.sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println(currentThreadName + " second:count=" + count + "\tage=" + this.student.getAge());
            lock2.unlock();
        }
    }


    public static void main(String[] args) {
        LockThread2 lt = new LockThread2();
        for (int i = 1; i <= 3; i++) {
            Thread t = new Thread(lt, "Thread" + i);
            t.start();
        }
    }

}

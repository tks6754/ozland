package demo01;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();

        Thread thread1 = new Thread(threadLocalDemo);
        Thread thread2 = new Thread(threadLocalDemo);

        thread1.start();
        thread2.start();
    }
}

package demo03.demo002;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by MiaoMU on 2017/3/14.
 */
public class Account {
    // 锁对象
    private final Lock lock = new ReentrantLock();
    // Condition对象
    private final Condition condDeposit = lock.newCondition();
    private final Condition condWithdraw = lock.newCondition();

    // 为避免double类型计算的误差，balance类型设计为int的
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void withdraw(int drawAmount) {
        // 加锁
        lock.lock();
        try {
            // 如果帐户余额不足，则取钱方法阻塞
            while (balance < drawAmount)
                condWithdraw.await();

            // 执行取钱
            balance -= drawAmount;
            System.out.println(Thread.currentThread().getName() + " 取钱:" + drawAmount + "账户余额为："
                    + balance);

            // 唤醒存款线程
            condDeposit.signal();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 按照目前设计，帐户余额大于1000后不让存款，必须先取款后才能再存。
    // 这与真实业务逻辑不符合，只是技术上需要才如此做的，否则存款一下子全存完就不好玩了。
    public void deposit(int depositAmount) {
        lock.lock();
        try {
            // 如果帐户余额大于1000，存钱方法阻塞
            while (balance > 1000)
                condDeposit.await();

            // 执行存款
            balance += depositAmount;
            System.out.println(Thread.currentThread().getName() + " 存款:" + depositAmount + "账户余额为："
                    + balance);

            // 唤醒取款线程
            condWithdraw.signal();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

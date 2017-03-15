package demo03.demo001;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithmState;

import java.util.concurrent.TimeUnit;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class Account {
    private double balance;

    public synchronized void addAmount(double amount){
        double tmp = balance;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tmp += amount;
        balance = tmp;
    }

    public synchronized void substractAmount(double amount){
        double tmp = balance;

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tmp -= amount;
        balance = tmp;

    }




    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

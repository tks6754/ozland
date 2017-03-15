package demo03.demo002;

/**
 * Created by MiaoMU on 2017/3/14.
 */
public class DepositDrawTest {

    public static void main(String[] args) {
        // 创建一个账户，初始帐户余额为0
        Account acct = new Account(0);

        // 注意下面的取款与存款的balance参数值需要匹配，
        // 否则可能造成存款过多而不让存，然后又没有人取款导致程序无法正常终止的问题。
        new DrawThread("取钱者1", acct, 400).start();
        new DrawThread("取钱者2", acct, 600).start();
        new DepositThread("存款者甲", acct, 600).start();
        new DepositThread("存款者乙", acct, 200).start();
        new DepositThread("存款者丙", acct, 400).start();
    }
}



class DrawThread extends Thread {
    // 模拟用户账户
    private Account account;
    // 每次取钱数
    private int drawAmount;

    public DrawThread(String name, Account account, int drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(drawAmount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}


class DepositThread extends Thread {
    // 模拟用户账户
    private Account account;
    // 每次存钱数
    private int depositAmount;

    public DepositThread(String name, Account account, int depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(depositAmount);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
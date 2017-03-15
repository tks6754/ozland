package demo03.demo001;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account){
        super();
        this.account=account;
    }

    public void run() {
        for (int i=0 ; i<10; i++){
            account.addAmount(1000);
        }
    }
}

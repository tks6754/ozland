package demo03.demo001;

/**
 * Created by MiaoMU on 2017/3/13.
 */
public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread threadCompany = new Thread(company);
        Bank bank = new Bank(account);
        Thread threadBank = new Thread(bank);

        System.out.printf("Account: Initial balance: %f \n", account.getBalance());
        threadCompany.start();
        threadBank.start();

        try {
            threadCompany.join();
            threadBank.join();
            System.out.printf("Account: Final balance: %f \n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

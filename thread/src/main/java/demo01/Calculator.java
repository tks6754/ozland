package demo01;

/**
 * Created by MiaoMU on 2017/3/12.
 */
public class Calculator implements Runnable {
    private int number;

    public Calculator(int nummber) {
        super();
        this.number = nummber;
    }

    public void run() {
        for (int i=0; i<10; i++){
            System.out.println(".........");
            System.out.printf("%s : %d * %d = %d /n", Thread.currentThread().getName(), number, i, i* number);
        }
    }



}

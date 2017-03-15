package demo01;

import java.util.concurrent.*;

/**
 * Created by MiaoMU on 2017/3/15.
 */
public class CallableAndFutureDemo {

    public static void main(String[] args) {
        MyCallabe task1 = new MyCallabe(0);
        MyCallabe task2 = new MyCallabe(1);
        MyCallabe task3 = new MyCallabe(2);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            Future future1 = executorService.submit(task1);
            System.out.println("task1: " + future1.get());

            Future future2 = executorService.submit(task2);
            Thread.sleep(5000);
            System.out.println("task2 cancel: " + future2.cancel(true));

            Future future3 = executorService.submit(task3);
            System.out.println("task3: " + future3.get());
        } catch (Exception e){
            System.out.println(e.toString());
        }

        executorService.shutdownNow();
    }




    public static class MyCallabe implements Callable{
        private int flag = 0;

        public MyCallabe(int flag){
            super();
            this.flag=flag;
        }

        public Object call() throws Exception {
            if (this.flag == 0){
                return "flag = 0";
            }
            if (this.flag == 1){
                // 如果flag的值为1，做一个无限循环
                try {
                    while (true) {
                        System.out.println("looping...");
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                }
                return "false";
            } else {
                // falg不为0或者1，则抛出异常
                throw new Exception("Bad flag value!");
            }
        }
    }

}

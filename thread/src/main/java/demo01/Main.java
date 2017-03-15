package demo01;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * Created by MiaoMU on 2017/3/12.
 */
public class Main {
    public static void main(String[] args) {
        for (int i=10; i<10; i++){
            Calculator c = new Calculator(i);
            Thread thread = new Thread(c);
            thread.start();
            c.run();
        }
    }
}

package demo01;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * Created by MiaoMU on 2017/3/9.
 */
public class Human {
    public static void main(String[] args) throws Exception{
        try {
            try {
                throw new Sneeze();
            }catch (Annoyance a){
                System.out.println("Caught Annoyance");
                throw a;
            }
        }catch (Sneeze s){
            System.out.println("Caught Sneeze");
            return;
        }finally {
            System.out.println("Hello world.");
        }
    }
}

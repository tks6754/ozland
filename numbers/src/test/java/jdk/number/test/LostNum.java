package jdk.number.test;

import org.junit.Test;

/**
 * flaot与double内存存储造成精度丢失
 * Created by miaomu on 16-12-29.
 */
public class LostNum {

    @Test
    public  void lost() {
        System.out.println(0.9999999999f == 1f);
        System.out.println(0.99f == 1f);

        System.out.println("============================");

        float f = 2.2f;
        double d = (double) f;
        System.out.println(f);
        System.out.println(d);
    }
}

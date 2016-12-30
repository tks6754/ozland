package jdk.bigdecimal.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by miaokun on 2016/12/30.
 */
public class DemoOfBigDecimal {

    /**
     * BigDecimal 两个常用的构造方法，为保证计算精确，使用BidDecimal（String val）
     */
    @Test
    public void testInit(){
        double d = 0.1;
        String s = "0.1";
        BigDecimal bigd = new BigDecimal(d);
        BigDecimal bigs = new BigDecimal(s);
        System.out.println(bigd.toString());
        System.out.println(bigs.toString());

        System.out.println(bigd.doubleValue());
        System.out.println(bigs.doubleValue());
    }


    @Test
    public void testScale(){

    }
}

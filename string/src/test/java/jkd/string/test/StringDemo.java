package jkd.string.test;

import org.junit.Test;

/**
 * Created by miaokun on 2016/12/30.
 */
public class StringDemo {

    @Test
    public void internTest(){
        String str = "aaa";
        System.out.println(str.intern());
    }
}

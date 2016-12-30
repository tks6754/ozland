package jdk.collections.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * list 遍历
 *
 * Created by miaomu on 16-12-29.
 */
public class ListTraversal {
    public static void main(String[] args) {
        //数据准备
        List<String> list = new ArrayList<String>();
        //List<String> list = new LinkedList<String>(); //对于 LinkedList是无顺序的，不支持list.get(i)
        long t1,t2;
        for(int j = 0; j < 10000000; j++) {
            list.add("fff" + j);
        }


        // for(int i = 0; i < list.size(); i++)
        System.out.println("List second visit method:");
        t1=System.currentTimeMillis();
        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            //System.out.println(list.get(i));
        }
        t2=System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 -t1) + "(ms)");

        // for (Iterator iter = list.iterator(); iter.hasNext();)
        System.out.println("List Third visit method:");
        t1=System.currentTimeMillis();
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String str = iter.next();
            //System.out.println(iter.next());
        }
        t2=System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 -t1) + "(ms)");


        // for(T item:items)
        System.out.println("List first visit method:");
        t1=System.currentTimeMillis();
        for(String tmp:list) {
            String str = tmp;
            //System.out.println(tmp);
        }
        t2=System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 -t1) + "(ms)");

        System.out.println("Finished!!!!!!!!");
    }

}

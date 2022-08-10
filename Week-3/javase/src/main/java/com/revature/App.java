package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.utils.Dequeue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Dequeue Demo" );

        Dequeue<Integer> dq = new Dequeue<Integer>();
        dq.addFirst(10);
        dq.addFirst(1);
        dq.addFirst(2);

        dq.addLast(10);
        dq.addLast(1);
        dq.addLast(2);

        // 2,1,10,10,1,2
        
        // System.out.println(dq.pollLast());
        // System.out.println(dq.pollLast());
        // System.out.println(dq.pollLast());
        // System.out.println(dq.pollLast());
        // System.out.println(dq.pollLast());
        // System.out.println(dq.pollLast());
        // System.out.println(dq.pollLast());

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(15);

        System.out.println("====Iterable Demo====");

        for (Integer integer : dq) {
            System.out.println(integer);
        }

    }
}

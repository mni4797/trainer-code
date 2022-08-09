package com.revature;

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

        Dequeue dq = new Dequeue<Integer>();
        dq.addFirst(10);
        dq.addFirst(1);
        dq.addFirst(2);

        System.out.println(dq.pollFirst());
        System.out.println(dq.pollFirst());
        System.out.println(dq.pollFirst());
        System.out.println(dq.pollFirst());
    }
}

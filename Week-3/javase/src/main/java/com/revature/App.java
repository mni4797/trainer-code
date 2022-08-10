package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.revature.models.Student;
import com.revature.utils.Dequeue;
import com.revature.utils.HistorySorter;

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

        System.out.println("====Comparable Demo====");
        Student s1 = new Student();
        s1.setMathGrade(100);
        s1.setHistoryGrade(70);
        s1.setScienceGrade(150);
        s1.setName("Stephen");
        Student s2 = new Student();
        s2.setName("Marielle");
        s2.setMathGrade(70);
        s2.setHistoryGrade(50);
        s2.setScienceGrade(80);
        Student s3 = new Student();
        s3.setName("Brandon");
        s3.setMathGrade(200);
        s3.setHistoryGrade(1);
        s3.setScienceGrade(10000);

        System.out.println(s1.compareTo(s2));

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("Unsorted List");
        for (Student student : students) {
            System.out.println(student.getMathGrade());
        }   
        
        System.out.println("Sorted List via Math grade");

        /**
         * Collections is a class that have a bunch of static methods to do some sort of operations for collections
         * One of them is sorting a collection
         * Another might be finding an element in a collection
         * 
         * Collection is an interface that is used to be inherited by our pre-defined data structures
         */

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.getMathGrade());
        }

        System.out.println("Sorted via History Grade");
        Collections.sort(students, new HistorySorter());

        for (Student student : students) {
            System.out.println(student.getHistoryGrade());
        }

        System.out.println("Sorted via Math with descending order");
        Collections.sort(students, Collections.reverseOrder());

        for (Student student : students) {
            System.out.println(student.getMathGrade());
        }

        System.out.println("Sorted via Science without a class");

        //Anonymous class example
        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                // TODO Auto-generated method stub
                return o1.getScienceGrade() - o2.getScienceGrade();
            }
            
        });

        for (Student student : students) {
            System.out.println(student.getScienceGrade());
        }
    }
}

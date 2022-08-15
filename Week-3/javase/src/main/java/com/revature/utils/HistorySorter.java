package com.revature.utils;

import java.util.Comparator;

import com.revature.models.Student;

//We need a separate class that implement Comparator if we want to compare more than what we did with compareTo()
public class HistorySorter implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        // TODO Auto-generated method stub
        return o1.getHistoryGrade() - o2.getHistoryGrade();
    }
    
}

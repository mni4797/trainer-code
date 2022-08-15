package com.revature.models;

//I need a way to compare two student objects and getting some sort of value
public class Student implements Comparable<Student>{

    private String name;
    private int mathGrade;
    private int historyGrade;
    private int scienceGrade;

    public String getName() {
        return name;
    }
    public int getScienceGrade() {
        return scienceGrade;
    }
    public void setScienceGrade(int scienceGrade) {
        this.scienceGrade = scienceGrade;
    }
    public int getHistoryGrade() {
        return historyGrade;
    }
    public void setHistoryGrade(int historyGrade) {
        this.historyGrade = historyGrade;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMathGrade() {
        return mathGrade;
    }
    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    //This method will be used to evaluate the comparison between Students
    //For now, I want to compare my students via their math grades
    @Override
    public int compareTo(Student o) {
        return this.mathGrade - o.getMathGrade();
    }
}

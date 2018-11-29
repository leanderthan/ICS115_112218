package com.example.cisco.nov22;

public class Grade {
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Grade(String fname, String lname, Long grade) {
        this.fname = getFname();
        this.lname = getLname();
        this.grade = getGrade();
    }

    String fname, lname;
    Long grade;

    public Long getGrade() {
        return grade;
    }



}

package com.example.cisco.nov22;

public class Grade {
    String fname, lname;
    Long grade;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Long getGrade() {
        return grade;
    }

    public Grade(String fname, String lname, Long grade) {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

}

package com.rajkumar.database;

import android.database.Cursor;

import java.io.Serializable;

public class Student implements Serializable {

    private int StudentID;
    private String studentName;
    private String studentAge;
    private String studentClass;
    private String studentMarks;

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID; }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String  getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentMarks() {
        return studentAge;
    }

    public void setStudentMarks(String studentMarks) {
        this.studentMarks = studentMarks;
    }

}

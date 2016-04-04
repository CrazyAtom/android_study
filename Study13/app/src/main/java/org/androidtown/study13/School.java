package org.androidtown.study13;

import java.util.ArrayList;

/**
 * Created by KHB on 2016-02-01.
 */
public class School {
    private String name;
    private ArrayList<Student> students = new ArrayList<Student>();

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addItem(Student student) {
        this.students.add(student);
    }

    public int size() {
        return this.students.size();
    }
}

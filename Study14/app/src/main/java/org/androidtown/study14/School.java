package org.androidtown.study14;

import java.util.ArrayList;
import java.util.Iterator;

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

    public String toString() {
        String studentList = "";
        for (int i = 0; i < students.size(); ++i) {
            Student student = students.get(i);
            if(student == null)
                continue;

            studentList += "학생#" + i + " : " + student.getName() + ", " + student.getAge() + "\n";
        }

        return studentList;
    }
}

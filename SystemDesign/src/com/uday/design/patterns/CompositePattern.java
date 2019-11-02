package com.uday.design.patterns;

import java.util.List;

public class CompositePattern {

}

interface StudentDetails {

    public String printDetails();
}

class Student implements StudentDetails {

    String name;

    @Override
    public String printDetails() {
        return name;
    }
}

class StudentDirectory implements StudentDetails {

    List<Student> students;

    @Override
    public String printDetails() {
        StringBuilder out = new StringBuilder();
        for (Student s : students) {
            out.append(s.printDetails());
            if (students.indexOf(s) != students.size()) {
                out.append(", ");
            }
        }
        return out.toString();
    }
}


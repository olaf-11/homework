package homework09.root;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String surname;
    private String middleName;
    private double averageScore;

    public Student(String studentName, String studentSurname, String studentMiddleName) {
        name = studentName;
        surname = studentSurname;
        middleName = studentMiddleName;
    }

    public Student(String studentName, String studentSurname, String studentMiddleName, double score) {
        name = studentName;
        surname = studentSurname;
        middleName = studentMiddleName;
        averageScore = score;
    }

    public String getFullName() {
        return surname + " " + name + " " + middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int compareTo(Student student){
        return this.getFullName().compareTo(student.getFullName());
    }

    @Override
    public String toString() {
        return getFullName() + ": \t" + getAverageScore();
    }
}
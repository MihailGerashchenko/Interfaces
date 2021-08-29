package GroupInterract;

import javax.swing.*;
import java.io.Serializable;
import java.util.Objects;

public class Student extends Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private String group;
    private long idCard;

    public Student() {
    }

    public Student(String name, String lastName, int age, Gender gender, String group, long idCard) {
        super(name, lastName, age, gender);
        this.group = group;
        this.idCard = idCard;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "group='" + group + '\'' +
                ", idCard=" + idCard + " " +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idCard == student.idCard && group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, idCard);
    }
}

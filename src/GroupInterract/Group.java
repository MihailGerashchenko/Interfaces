package GroupInterract;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group implements Voenkom, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Student[] students = new Student[10];

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Boolean addStudent(Student student) throws GroupEngagedException {
        for (int i = 0; i <= students.length; i++) {
            if (i > 9) {
                throw new GroupEngagedException("The group " + getName() + " is already engaged, the last student was " + students[9].getName());
            }
            if (student == null) {
                throw new IllegalArgumentException("Null student");
            }
            if (students[i] == null) {
                students[i] = student;
                return true;
            }
        }
        return false;
    }

    public Boolean removeStudent(Long id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getIdCard() == id) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public Student findStudent(String lastName) throws NoSuchLastNameStudentException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName().equals(lastName)) {
                return students[i];
            }
        }
        throw new NoSuchLastNameStudentException("There is no student with such lastname");
    }

    public Student createAndAddStudentIntoGroup() throws NumberFormatException, NullPointerException, GroupEngagedException {
        for (; ; ) {
            try {
                String name = String.valueOf(JOptionPane.showInputDialog("Input name"));
                String lastname = String.valueOf(JOptionPane.showInputDialog("Input lastName"));
                int age = Integer.valueOf(JOptionPane.showInputDialog("Input age"));
                Gender gender = Gender.valueOf(JOptionPane.showInputDialog(null, "Input your gender MALE/FEMALE"));
                String group = String.valueOf(JOptionPane.showInputDialog("Input group name"));
                long idCard = Long.valueOf(JOptionPane.showInputDialog("Input the ID card number"));

                Student student = new Student(name, lastname, age, gender, group, idCard);
                addStudent(student);
                return student;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wrong number format");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Cancel");
                break;
            }
            break;
        }
        return null;
    }

    public void sortStudentsForLastNames() {
        Arrays.sort(students, Comparator.nullsLast(new StudentsLasNameComparator()));
        System.out.println(students);
    }

    public void sortStudentsForAge() {
        Arrays.sort(students, Comparator.nullsLast(new StudentAgeComparator()));
        System.out.println(students);
    }

    public void showArray(Group group) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void saveGroupIntoFile(Student[] students) throws IOException {
        try (PrintStream outWrite = new PrintStream(new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\Group.CSV"))) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null) {
                    outWrite.println(students[i]);
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    @Override
    public Student[] getRecrut() {
        Student[] warriors = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getGender() == Gender.MALE && students[i].getAge() >= 18) {
                warriors[i] = students[i];
            }
        }
        return warriors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return name.equals(group.name) && Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}

package GroupInterract;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Group group = new Group("MSKD");

        try {
            group.createAndAddStudentIntoGroup();
        } catch (GroupEngagedException e) {
            e.printStackTrace();
        }

        try {
            group.createAndAddStudentIntoGroup();
        } catch (GroupEngagedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(group.findStudent("Alibaba"));
        } catch (NoSuchLastNameStudentException e) {
            e.printStackTrace();
        }

        group.removeStudent(1896L);

        group.sortStudentsForAge();
        group.sortStudentsForLastNames();

        Student[] warriors = group.getRecrut();
        for (Student each : warriors) {
            if (each == null) {
                continue;
            } else {
                System.out.println(each);
            }
        }
    }
}

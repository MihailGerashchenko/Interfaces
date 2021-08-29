package GroupInterract;

import java.io.*;
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
        System.out.println(group);
        try {
            System.out.println(group.findStudent("Alibaba"));
        } catch (NoSuchLastNameStudentException e) {
            e.getMessage();
        }

        group.removeStudent(1896L);

        group.sortStudentsForAge();
        group.sortStudentsForLastNames();

        Student[] warriors = group.getRecrut();
        for (int i = 0; i < warriors.length; i++) {
            if (warriors[i] == null) {
                continue;
            } else {
                System.out.println(warriors[i]);
            }
        }

        File file = new File("C:\\Users\\Lenovo\\Desktop\\ForJava.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(file))) {
            OOS.writeObject(group);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Group MSKD = null;
        try(ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(file))){
            MSKD = (Group) OIS.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(group);
        System.out.println(MSKD);
        System.out.println(group.equals(MSKD));
    }
}

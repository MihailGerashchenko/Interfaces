package GroupInterract;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;

        int age1 = student1.getAge();
        int age2 = student2.getAge();

        if (age1 > age2) {
            return 1;
        }
        if (age1 < age2) {
            return -1;
        }
        return 0;
    }
}

package homework09.root;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAverageScore() != o2.getAverageScore()) {
            // Если сделать ((o2.getAverageScore() - o1.getAverageScore()) * 10)
            // будут проблемы с неточнотью расчетов и приведения типов:
            // 2.999999999 обрубится до 2 вместо 3, к примеру.
            return (int) (o2.getAverageScore() * 10 - o1.getAverageScore() * 10);
        } else {
            return o1.getFullName().compareTo(o2.getFullName());
        }
    }
}

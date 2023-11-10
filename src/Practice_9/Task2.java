package Practice_9;

import java.util.Comparator;

class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getGPA(), student1.getGPA());
    }
}

public class Task2 {
    private static int separation(Student[] students, int l, int r) {
        Student separator = students[r];
        int i = l - 1;

        Student temp;
        for (int j = l; j < r; j++) {
            if (students[j].getSortingByGPA().compare(students[j], separator) < 1) {
                temp = students[++i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
        temp = students[++i];
        students[i] = students[r];
        students[r] = temp;
        return i;
    }

    public static void quickSort(Student[] students, int l, int r) {
        if (l < r) {
            int separator = separation(students, l, r);

            quickSort(students, l, separator - 1);
            quickSort(students, separator + 1, r);
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(112, 5.0, "Андрей"),
                new Student(93, 4.2, "Павел"),
                new Student(132, 3.9, "Арсений"),
                new Student(104, 4.5, "Алексей"),
                new Student(99, 4.1, "Игорь")
        };
        quickSort(students, 0, students.length - 1);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}


package Practice_9;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void mergeSort(List<Student> a, int l, int r) {
        if (r == l) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);

        int i = l;
        int j = m + 1;
        List<Student> temp = new ArrayList<>();
        for (int step = 0; step < r - l + 1; step++) {
            if ((j > r) || (i <= m && a.get(i).compareTo(a.get(j)) <= 0)) {
                temp.add(a.get(i++));
            } else {
                temp.add(a.get(j++));
            }
        }
        for (int step = 0; step < temp.size(); step++) {
            a.set(l + step, temp.get(step));
        }
    }

    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(112, 5.0, "Андрей"));
        list1.add(new Student(93, 4.2, "Павел"));
        list1.add(new Student(132, 3.9, "Арсений"));
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(104, 4.5, "Алексей"));
        list2.add(new Student(99, 4.1, "Игорь"));
        List<Student> students = new ArrayList<>(list1);
        students.addAll(list2);
        mergeSort(students, 0, students.size() - 1);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

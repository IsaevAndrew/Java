package Practice_10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String specialty;
    private int course;
    private String group;
    private double gpa;

    public Student(int id, String firstName, String lastName, String specialty, int course, String group, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}


public class SortingStudentsByGPA {
    private List<Student> iDNumber;

    public SortingStudentsByGPA() {
        iDNumber = new ArrayList<>();
    }

    public void setArray(List<Student> students) {
        iDNumber = students;
    }

    public void quickSort() {
        mergeSort(iDNumber, 0, iDNumber.size() - 1, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Double.compare(student1.getGpa(), student2.getGpa());
            }
        });
    }

    private void mergeSort(List<Student> list, int left, int right, Comparator<Student> comparator) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid, comparator);
            mergeSort(list, mid + 1, right, comparator);
            merge(list, left, mid, right, comparator);
        }
    }

    private void merge(List<Student> list, int left, int mid, int right, Comparator<Student> comparator) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Student> leftList = new ArrayList<>(n1);
        List<Student> rightList = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++) {
            leftList.add(list.get(left + i));
        }
        for (int i = 0; i < n2; i++) {
            rightList.add(list.get(mid + 1 + i));
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (comparator.compare(leftList.get(i), rightList.get(j)) >= 0) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    public void outArray() {
        for (Student student : iDNumber) {
            System.out.println(student);
        }
    }

    public void sortByField() {
        mergeSort(iDNumber, 0, iDNumber.size() - 1, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Double.compare(student2.getCourse(), student1.getCourse());
            }
        });
    }

    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        // Создаем список студентов
        List<Student> students1 = new ArrayList<>();
        students1.add(new Student(12, "Dwayne", "Johnson", "Прикинфа", 3, "ИНБО-07-22", 4.5));
        students1.add(new Student(14, "Arnold", "Schwarzenegger", "ИВТ", 2, "ИВБО-06-22", 3.8));

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student(47, "Angelina", "Jolie", "Прикматан", 4, "ИМБО-01-22", 4.9));
        students2.add(new Student(45, "Brad", "Pitt", "Прогкринж", 1, "ИКБО-20-22", 4.2));
        students2.add(new Student(7, "Tom", "Cruise", "ИВТ", 2, "ИВБО-01-22", 3.9));
        List<Student> students = new ArrayList<>();
        students.addAll(students1);
        students.addAll(students2);
        sorter.setArray(students);
        System.out.println("Сортировка по среднему баллу:");
        sorter.quickSort();
        sorter.outArray();
        System.out.println("\nСортировка по курсу:");
        sorter.sortByField();
        sorter.outArray();
    }
}


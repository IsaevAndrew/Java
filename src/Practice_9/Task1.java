package Practice_9;

class Student implements Comparable<Student> {
    private int id;
    private double GPA;
    private String name;
    private SortingStudentsByGPA sortingByGPA = new SortingStudentsByGPA();

    public Student(int id, double GPA, String name) {
        this.id = id;
        this.GPA = GPA;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getGPA() {
        return GPA;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", GPA=" + GPA +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    public SortingStudentsByGPA getSortingByGPA() {
        return sortingByGPA;
    }
}

public class Task1 {
    public static void main(String[] args) {
        Student[] students = {
                new Student(112, 5.0, "Андрей"),
                new Student(93, 4.2, "Павел"),
                new Student(132, 3.9, "Арсений"),
                new Student(104, 4.5, "Алексей"),
                new Student(99, 4.1, "Игорь")
        };

        System.out.println("Массив до сортировки:");
        printStudents(students);
        insertionSort(students);
        System.out.println("\nМассив после сортировки по id:");
        printStudents(students);
    }

    public static void insertionSort(Student[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Student key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

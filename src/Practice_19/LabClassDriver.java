package Practice_19;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    private String firstName;
    private String lastName;
    private double gpa;

    public Student(String firstName, String lastName, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Студент{" +
                "Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                ", Средний балл=" + gpa +
                '}';
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class LabClass {
    private List<Student> students;

    public LabClass() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) throws EmptyStringException {
        if (student.getFirstName().isEmpty() || student.getLastName().isEmpty()) {
            throw new EmptyStringException("Имя и фамилия студента не могут быть пустыми.");
        }
        students.add(student);
    }

    public List<Student> findStudents(String lastName) throws StudentNotFoundException {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getLastName().equals(lastName)) {
                foundStudents.add(student);
            }
        }
        if (foundStudents.isEmpty()) {
            throw new StudentNotFoundException("Студент с фамилией " + lastName + " не найден.");
        }
        return foundStudents;

    }

    public void sortStudentsByGPA() {
        students.sort(Comparator.comparingDouble(Student::getGpa));
    }

    public List<Student> getStudents() {
        return students;
    }
}


class LabClassUI {
    private LabClass labClass;

    public LabClassUI(LabClass labClass) {
        this.labClass = labClass;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Добавить студента");
            System.out.println("2. Найти студента");
            System.out.println("3. Отсортировать студентов по среднему баллу");
            System.out.println("4. Выйти");
            System.out.print("Введите ваш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    findStudent(scanner);
                    break;
                case 3:
                    sortStudentsByGPA();
                    break;
                case 4:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        } while (choice != 4);
    }

    private void addStudent(Scanner scanner) {
        try {
            System.out.print("Введите имя студента: ");
            String firstName = scanner.nextLine();

            if (firstName.isEmpty()) {
                throw new EmptyStringException("Имя студента не может быть пустым.");
            }

            System.out.print("Введите фамилию студента: ");
            String lastName = scanner.nextLine();

            if (lastName.isEmpty()) {
                throw new EmptyStringException("Фамилия студента не может быть пустой.");
            }

            System.out.print("Введите средний балл студента: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();

            Student student = new Student(firstName, lastName, gpa);
            labClass.addStudent(student);
            System.out.println("Студент успешно добавлен.");
        } catch (EmptyStringException e) {
            System.out.println(e.getMessage());
        }
    }

    private void findStudent(Scanner scanner) {
        System.out.print("Введите фамилию студента для поиска: ");
        String lastName = scanner.nextLine();
        try {
            List<Student> foundStudents = labClass.findStudents(lastName);
            System.out.println("Найдены студенты с фамилией " + lastName + ":");
            for (Student student : foundStudents) {
                System.out.println(student);
            }

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }


    private void sortStudentsByGPA() {
        labClass.sortStudentsByGPA();
        System.out.println("Студенты отсортированы по среднему баллу:");
        for (Student student : labClass.getStudents()) {
            System.out.println(student);
        }
    }
}

public class LabClassDriver {
    public static void main(String[] args) {
        LabClass labClass = new LabClass();
        LabClassUI labClassUI = new LabClassUI(labClass);
        labClassUI.run();
    }
}

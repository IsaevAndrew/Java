package Practice_11;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


enum Format {
    SHORT,
    MEDIUM,
    Long
}

class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String specialty;
    private int course;
    private String group;
    private double gpa;
    private Date birthDate;

    public Student(int id, String firstName, String lastName, String specialty, int course, String group, double gpa, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.gpa = gpa;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String toString(String dateFormatPattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
        String formattedDateOfBirth = dateFormat.format(birthDate);

        return "Имя: " + firstName + "\n" +
                "Фамилия: " + lastName + "\n" +
                "Специальность: " + specialty + "\n" +
                "Курс: " + course + "\n" +
                "Группа: " + group + "\n" +
                "Средний балл: " + gpa + "\n" +
                "Дата рождения: " + formattedDateOfBirth;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Date birthDate = new Date(104, 11, 8);

        Student student = new Student(12, "Dwayne", "Johnson", "Прикинфа", 3, "ИНБО-07-22", 4.5, birthDate);

        System.out.println("Выберите формат даты для вывода информации о студенте:");
        System.out.println("1. Короткий формат (год, месяц, день)");
        System.out.println("2. Средний формат (год, месяц, день, день недели)");
        System.out.println("3. Полный формат (год, месяц, день, день недели, часы, минуты, секунды)");

        int choice = scanner.nextInt();
        String dateFormatPattern = null;

        switch (choice) {
            case 1:
                dateFormatPattern = "yyyy-MM-dd";
                break;
            case 2:
                dateFormatPattern = "yyyy-MM-dd E";
                break;
            case 3:
                dateFormatPattern = "yyyy-MM-dd E HH:mm:ss";
                break;
            default:
                System.out.println("Неверный выбор формата.");
                return;
        }

        System.out.println("\nИнформация о студенте:");
        System.out.println(student.toString(dateFormatPattern));
    }
}

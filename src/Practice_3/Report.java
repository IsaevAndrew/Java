package Practice_3;

import java.util.Locale;

class Employee {
    private String fullname;
    private double salary;

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    public String getFullname() {
        return fullname;
    }

    public double getSalary() {
        return salary;
    }
}

public class Report {
    public static void generateReport(Employee[] employees) {
        System.out.println("Отчет о сотрудниках:");
        System.out.printf("%-30s %20s%n", "ФИО сотрудника", "Зарплата");
        System.out.println("===================================================");
        for (Employee employee : employees) {
            System.out.printf("%-30s %20s%n", employee.getFullname(), String.format(Locale.US, "%.2f", employee.getSalary()));
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иванов Иван", 1247.732),
                new Employee("Петров Петр", 7221.013),
                new Employee("Сидоров Сидор", 4957.488)
        };
        generateReport(employees);
    }
}


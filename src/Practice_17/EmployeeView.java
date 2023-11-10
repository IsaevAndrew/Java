package Practice_17;

public class EmployeeView {
    public void printEmployeeDetails(Employee employee) {
        System.out.println("Фамилия: " + employee.getLastName());
        System.out.println("Имя: " + employee.getFirstName());
        System.out.println("Отчество: " + employee.getMiddleName());
        System.out.println("Номер телефона: " + employee.getPhoneNumber());
        System.out.println("Должность: " + employee.getPosition());
        System.out.println("Зарплата: " + employee.getSalary());
        System.out.println();
    }
}

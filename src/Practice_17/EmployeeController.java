package Practice_17;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private EmployeeView view;
    private List<Employee> employees;

    public EmployeeController(EmployeeView view) {
        this.view = view;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void displayEmployeeDetails(Employee employee) {
        view.printEmployeeDetails(employee);
    }

    public void displayAllEmployees() {
        for (Employee employee : employees) {
            view.printEmployeeDetails(employee);
        }
    }
}
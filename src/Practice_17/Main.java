package Practice_17;

public class Main {
    public static void main(String[] args) {
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(view);
        Employee employee1 = new Employee("Алексеев", "Александр", "Юрьевич", "89692151247", "Менеджер", 60000.0);
        Employee employee2 = new Employee("Фокин", "Александр", "Вячеславович", "88005553535", "Тестировщик", 30000.0);

        controller.addEmployee(employee1);
        controller.addEmployee(employee2);

        controller.displayAllEmployees();
    }
}


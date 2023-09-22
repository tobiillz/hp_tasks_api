package com.personal.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {
    private final Employees employees;

    public EmployeeManager(Employees employees) {
        this.employees = employees;

        // Hard-code 3-4 example employees
        employees.addEmployee(new Employee("1", "John", "Doe", "john@example.com", "Manager"));
        employees.addEmployee(new Employee("2", "Jane", "Smith", "jane@example.com", "Developer"));
        employees.addEmployee(new Employee("3", "Alice", "Johnson", "alice@example.com", "Designer"));
        // Add more employees if needed
    }
}

package com.personal.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    Employee employee;

    private Employees employees;

    public EmployeeController(Employees employees) {
        this.employees = employees;
    }

//    @GetMapping("/employees")
//    public Employee getEmployee(//@RequestParam(name = "employee_id") String employee_id
//    ){
//        return employee;
////       return new Employee("0001","opeoluwa","victor","victoro@yahoo.com","mr");
//    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employees.getEmployeeList();
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee) {
        // Add the new employee to the employees list (assuming Employees.getEmployeeList() returns a List<Employee>)
        this.employee = employee;
        return "Employee created successfully";
    }
}

package com.personal.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private Employees employees;

    public EmployeeController(Employees employees) {
        this.employees = employees;
    }



    @GetMapping("/employee")
    public Employee getEmployee(){
        return new Employee("0001","opeoluwa","victor","victoro@yahoo.com","mr");
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employees.getEmployeeList();
    }

//    public Employee addEmployee(){
//
//    }
}

package com.personal.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @MockBean
    Employees employees;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getEmployees() throws Exception {
        List<Employee> employeeList = Arrays.asList(new Employee("1", "John", "Doe", "john@example.com", "Manager"));
        new Employee("2", "Jane", "Smith", "jane@example.com", "Developer");

        when(Employees.getEmployeeList).thenReturn(employeeList);
        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].first_name").value("John"));

    }

    @Test
    public void addEmployee(){
            Employee employee = new Employee(100L,"Lipsa","Patra","lipsa@gmail.com","123456");
            when(Employees.addEmployee(employee)).thenReturn(employee);
            mockMvc.perform(post("/employee")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(employee)))
                    .andExpect(status().isOk());

        }

    }
}

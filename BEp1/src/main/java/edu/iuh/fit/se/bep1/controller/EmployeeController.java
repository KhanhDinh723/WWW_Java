package edu.iuh.fit.se.bep1.controller;

import edu.iuh.fit.se.bep1.dtos.ApiResponse;
import edu.iuh.fit.se.bep1.entities.Employee;
import edu.iuh.fit.se.bep1.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   10/29/2025
 * Time:   8:49 PM
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ApiResponse<List<Employee>> getAllEmployees(){
        return new ApiResponse<>(HttpStatus.OK.value(),employeeService.findAll());
    }
    @GetMapping("/{id}")
    public ApiResponse<Employee> getEmployeeById (@PathVariable Integer id){

        return new ApiResponse<>(HttpStatus.OK.value(), employeeService.findById(id));
    }
    @PostMapping
    public ApiResponse<Employee> addEmployee(@RequestBody Employee e) {
        return new ApiResponse<>(HttpStatus.CREATED.value(), employeeService.save(e));
    }
    @PutMapping("/{id}")
    public ApiResponse<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee e) {
        e.setId(id);
        return new ApiResponse<>(HttpStatus.OK.value(), employeeService.save(e));
    }
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return new ApiResponse<>(HttpStatus.NO_CONTENT.value(), "Deleted successfully");
    }

}

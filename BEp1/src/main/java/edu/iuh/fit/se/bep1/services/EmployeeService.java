package edu.iuh.fit.se.bep1.services;

import edu.iuh.fit.se.bep1.entities.Employee;

import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   10/29/2025
 * Time:   8:53 PM
 */
public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee save(Employee e);
    void delete(Integer id);
}

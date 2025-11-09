package edu.iuh.fit.se.bep1.services.impl;

import edu.iuh.fit.se.bep1.entities.Employee;
import edu.iuh.fit.se.bep1.repositories.EmployeeRepository;
import edu.iuh.fit.se.bep1.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
}

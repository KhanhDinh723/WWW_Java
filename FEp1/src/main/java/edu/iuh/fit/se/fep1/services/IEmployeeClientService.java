package edu.iuh.fit.se.fep1.services;

import edu.iuh.fit.se.fep1.dtos.Employee;
import java.util.List;

public interface IEmployeeClientService {
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee create(Employee e);
    Employee update(Integer id, Employee e);
    void delete(Integer id);
}

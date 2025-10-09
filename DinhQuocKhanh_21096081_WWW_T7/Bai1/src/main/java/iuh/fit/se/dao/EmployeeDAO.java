package iuh.fit.se.dao;

import java.util.List;
import iuh.fit.se.entity.Employee;

public interface EmployeeDAO {
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(int id);
    Employee getById(int id);
    List<Employee> getAll();
}

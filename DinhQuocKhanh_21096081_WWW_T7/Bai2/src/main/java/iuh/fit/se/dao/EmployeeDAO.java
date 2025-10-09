package iuh.fit.se.dao;

import iuh.fit.se.model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void save(Employee e);
    List<Employee> getAll();
}

package iuh.se.fit.service;

import iuh.se.fit.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface EmployeeService {
    Page<Employee> search(String q, Pageable pageable);
    Page<Employee> list(Pageable pageable);
    Employee save(Employee e);
    Optional<Employee> get(Long id);
    void delete(Long id);
}

package iuh.se.fit.repo;

import iuh.se.fit.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String fn, String ln, String email, Pageable pageable);
    boolean existsByEmail(String email);
}

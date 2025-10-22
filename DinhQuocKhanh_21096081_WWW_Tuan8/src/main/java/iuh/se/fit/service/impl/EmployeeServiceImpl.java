package iuh.se.fit.service.impl;

import iuh.se.fit.entities.Employee;
import iuh.se.fit.repo.EmployeeRepository;
import iuh.se.fit.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeServiceImpl(EmployeeRepository repo) { this.repo = repo; }

    @Override
    public Page<Employee> search(String q, Pageable pageable) {
        if (q == null || q.isBlank()) return repo.findAll(pageable);
        return repo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(q, q, q, pageable);
    }
    @Override public Page<Employee> list(Pageable pageable) { return repo.findAll(pageable); }
    @Override public Employee save(Employee e) { return repo.save(e); }
    @Override public Optional<Employee> get(Long id) { return repo.findById(id); }
    @Override public void delete(Long id) { repo.deleteById(id); }
}

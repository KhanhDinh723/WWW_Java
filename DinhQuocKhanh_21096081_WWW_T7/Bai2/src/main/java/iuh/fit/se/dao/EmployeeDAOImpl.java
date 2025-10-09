package iuh.fit.se.dao;

import iuh.fit.se.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Employee e) {
        jdbcTemplate.update("INSERT INTO employees (name, role) VALUES (?, ?)",
                e.getName(), e.getRole());
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employees",
                (rs, rowNum) -> new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role")));
    }
}

package iuh.fit.se.daoImpl;

import iuh.fit.se.dao.EmployeeDAO;
import iuh.fit.se.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees (name, role) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name=?, role=? WHERE id=?";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM employees WHERE id=?", id);
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM employees WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employees", new BeanPropertyRowMapper<>(Employee.class));
    }
}

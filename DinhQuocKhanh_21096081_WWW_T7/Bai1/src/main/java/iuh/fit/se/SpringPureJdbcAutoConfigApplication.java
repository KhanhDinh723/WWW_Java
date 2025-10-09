package iuh.fit.se;

import iuh.fit.se.dao.EmployeeDAO;
import iuh.fit.se.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.dao", "iuh.fit.se.daoImpl"})
public class SpringPureJdbcAutoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPureJdbcAutoConfigApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(EmployeeDAO employeeDAO) {
        return args -> {
            Employee e = new Employee("Nguyen Van A", "Admin");
            employeeDAO.save(e);

            List<Employee> list = employeeDAO.getAll();
            list.forEach(System.out::println);

            Employee emp = employeeDAO.getById(1);
            System.out.println("Employee 1: " + emp);
        };
    }
}

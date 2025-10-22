package iuh.se.fit.web;

import iuh.se.fit.entities.Employee;
import iuh.se.fit.entities.Employee.Gender;
import iuh.se.fit.repo.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataSeeder {
    @Bean
    public CommandLineRunner seed(EmployeeRepository repo) {
        return args -> {
            if (repo.count() > 0) return;
            List<Employee> samples = List.of(
                    List < Employee > employees = List.of(
                            new Employee("Nguyen", "Khanh", Gender.male, LocalDate.of(2000, 4, 12), "khanhnguyen@gmail.com", "(090)123-4567", "HCMC"),
                            new Employee("Tran", "Mai", Gender.female, LocalDate.of(1998, 8, 25), "maitran@gmail.com", "(091)345-6789", "Ha Noi"),
                            new Employee("Le", "Tuan", Gender.male, LocalDate.of(1995, 11, 3), "tuanle@example.com", "(092)234-5678", "Da Nang"),
                            new Employee("Pham", "Thu", Gender.female, LocalDate.of(2001, 2, 18), "thupham@gmail.com", "(093)567-1234", "Can Tho"),
                            new Employee("Do", "Quang", Gender.male, LocalDate.of(1997, 6, 5), "quangdo@yahoo.com", "(094)456-7890", "Hue"),
                            new Employee("Vo", "Linh", Gender.female, LocalDate.of(2000, 9, 30), "linhvo@example.com", "(095)321-6547", "HCMC"),
                            new Employee("Bui", "Duy", Gender.male, LocalDate.of(1996, 12, 10), "duybui@gmail.com", "(096)876-5432", "Da Nang"),
                            new Employee("Ho", "Nhi", Gender.female, LocalDate.of(2003, 3, 22), "nhiho@gmail.com", "(097)111-2222", "Ha Noi"),
                            new Employee("Dang", "Son", Gender.male, LocalDate.of(1994, 7, 15), "sondang@hotmail.com", "(098)333-4444", "Can Tho"),
                            new Employee("Phan", "Yen", Gender.female, LocalDate.of(2002, 10, 8), "yenphan@gmail.com", "(099)555-6666", "Hue")
                    );

            );
            samples.forEach(e -> {
                if (!repo.existsByEmail(e.getEmail())) repo.save(e);
            });
        };
    }
}

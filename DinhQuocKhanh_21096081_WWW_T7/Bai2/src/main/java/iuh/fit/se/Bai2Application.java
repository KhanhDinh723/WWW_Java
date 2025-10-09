package iuh.fit.se;

import iuh.fit.se.config.AppConfig;
import iuh.fit.se.dao.EmployeeDAO;
import iuh.fit.se.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
@Import(AppConfig.class)
public class Bai2Application {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Bai2Application.class, args);

		EmployeeDAO dao = ctx.getBean(EmployeeDAO.class);

		dao.save(new Employee("Tran Van B", "Staff"));
		dao.getAll().forEach(System.out::println);
	}
}

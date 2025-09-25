package iuh.fit.se.bai2;

import iuh.fit.se.bai2.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfig {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Employee e = context.getBean(Employee.class);
        System.out.println("Java-Based Config: " + e);
    }
}

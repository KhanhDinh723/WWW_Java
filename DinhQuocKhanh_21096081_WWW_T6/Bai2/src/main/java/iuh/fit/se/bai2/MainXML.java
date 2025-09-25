package iuh.fit.se.bai2;

import iuh.fit.se.bai2.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXML {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Employee e1 = context.getBean("employee1", Employee.class);
        Employee e2 = context.getBean("employee1", Employee.class);

        System.out.println("Setter Injection: " + e1);
        System.out.println("Constructor Injection: " + e2);
    }
}

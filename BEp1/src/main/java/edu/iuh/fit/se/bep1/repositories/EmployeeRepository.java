package edu.iuh.fit.se.bep1.repositories;

import edu.iuh.fit.se.bep1.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Khánh Đinh
 * Date:   10/29/2025
 * Time:   8:52 PM
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

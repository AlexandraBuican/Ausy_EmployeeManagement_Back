package com.Ausy_Technologies.employees.Repository;

import com.Ausy_Technologies.employees.Model.DAO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

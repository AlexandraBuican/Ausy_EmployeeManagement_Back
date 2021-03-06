package com.Ausy_Technologies.employees.Repository;

import com.Ausy_Technologies.employees.Model.DAO.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public Department findById(int id);
}

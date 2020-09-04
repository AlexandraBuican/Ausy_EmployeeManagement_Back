package com.Ausy_Technologies.employees.Service;

import com.Ausy_Technologies.employees.Model.DAO.Department;
import com.Ausy_Technologies.employees.Repository.DepartmentRepository;
import com.Ausy_Technologies.employees.Repository.EmployeeRepository;
import com.Ausy_Technologies.employees.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department addDepartment(Department department)
    {
        return this.departmentRepository.save(department);
    }

    public List<Department> findAllDepartments()
    {
        return this.departmentRepository.findAll();
    }

    public void deleteDepartmentById(int id)
    {
        this.departmentRepository.deleteById(id);
    }

}

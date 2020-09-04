package com.Ausy_Technologies.employees.Controller;

import com.Ausy_Technologies.employees.Model.DAO.Department;
import com.Ausy_Technologies.employees.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;




    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department)
    {
        Department departmentAdded = this.departmentService.addDepartment(department);
        return departmentAdded;
    }

    @GetMapping("/findAllDepartments")
    public List<Department> findAllDepartments()
    {
        return departmentService.findAllDepartments();
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable int id)
    {
        this.departmentService.deleteDepartmentById(id);
    }


}

package com.Ausy_Technologies.employees.Controller;

import com.Ausy_Technologies.employees.Model.DAO.Department;
import com.Ausy_Technologies.employees.Model.DAO.JobCategory;
import com.Ausy_Technologies.employees.Service.DepartmentService;
import com.Ausy_Technologies.employees.Service.EmployeeService;
import com.Ausy_Technologies.employees.Service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobCategory")
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @PostMapping("/addJobCategory")
    public JobCategory jobCategory(@RequestBody JobCategory jobCategory)
    {
        JobCategory jobCategoryAdded = this.jobCategoryService.addJobCategory(jobCategory);
        return jobCategoryAdded;
    }

    @GetMapping("/findAllJobCategories")
    public List<JobCategory> findAllJobCategories()
    {
        return jobCategoryService.findAllJobCategories();
    }

    @DeleteMapping("/deleteJobCategory/{id}")
    public void deleteJobCategory(@PathVariable int id)
    {
        this.jobCategoryService.deleteJobCategoryById(id);
    }

}

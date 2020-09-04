package com.Ausy_Technologies.employees.Service;

import com.Ausy_Technologies.employees.Model.DAO.Department;
import com.Ausy_Technologies.employees.Model.DAO.JobCategory;
import com.Ausy_Technologies.employees.Repository.DepartmentRepository;
import com.Ausy_Technologies.employees.Repository.EmployeeRepository;
import com.Ausy_Technologies.employees.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryService {

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public JobCategory addJobCategory(JobCategory jobCategory)
    {
        return this.jobCategoryRepository.save(jobCategory);
    }

    public List<JobCategory> findAllJobCategories()
    {
        return this.jobCategoryRepository.findAll();
    }

    public void deleteJobCategoryById(int id)
    {
        this.jobCategoryRepository.deleteById(id);
    }





}

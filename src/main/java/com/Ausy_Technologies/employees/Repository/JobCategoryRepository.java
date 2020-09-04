package com.Ausy_Technologies.employees.Repository;

import com.Ausy_Technologies.employees.Model.DAO.Department;
import com.Ausy_Technologies.employees.Model.DAO.JobCategory;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {

    public JobCategory findById(int id);
}

package com.Ausy_Technologies.employees.Model.DTO;

import com.Ausy_Technologies.employees.Model.DAO.Department;
import com.Ausy_Technologies.employees.Model.DAO.JobCategory;

public class EmployeeDto {

    private String firstName;
    private String lastName;
    private String department;
    private String jobCategory;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", jobCategory='" + jobCategory + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

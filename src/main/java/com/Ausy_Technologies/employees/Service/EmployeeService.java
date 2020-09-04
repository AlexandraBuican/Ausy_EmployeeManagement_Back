package com.Ausy_Technologies.employees.Service;

import antlr.MismatchedCharException;
import com.Ausy_Technologies.employees.Error.ErrorResponse;
import com.Ausy_Technologies.employees.Model.DAO.Department;
import com.Ausy_Technologies.employees.Model.DAO.Employee;
import com.Ausy_Technologies.employees.Model.DAO.JobCategory;
import com.Ausy_Technologies.employees.Repository.DepartmentRepository;
import com.Ausy_Technologies.employees.Repository.EmployeeRepository;
import com.Ausy_Technologies.employees.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public Employee addEmployee(Employee employee)
    {
        return this.employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees()
    {
        return this.employeeRepository.findAll();
    }


    public Employee addEmployee2(Employee employee, int departmentId, int jobCategoryId) throws ErrorResponse {
        Department department;
        JobCategory jobCategory;
        try {
            department = this.departmentRepository.findById(departmentId);
            jobCategory = this.jobCategoryRepository.findById(jobCategoryId);
        }catch (NoSuchElementException noSuchElementException) {
            throw new ErrorResponse(noSuchElementException.getMessage());
        }
        employee.setDepartment(department);
        employee.setJobCategory(jobCategory);

        return this.employeeRepository.save(employee);

    }


    public void deleteEmployeeById(int id) throws ErrorResponse {
        try{
            this.employeeRepository.findById(id).get();
        }catch (NoSuchElementException noSuchElementException){
            throw new ErrorResponse(noSuchElementException.getMessage());
        }
        this.employeeRepository.deleteById(id);
    }


    public Employee getEmployeeById(int id) throws ErrorResponse {
        try{
            this.employeeRepository.findById(id).get();
        }catch (NoSuchElementException noSuchElementException){
            throw new ErrorResponse(noSuchElementException.getMessage());
        }
        return this.employeeRepository.findById(id).get();
    }



    public List<Employee> getEmployeesByDep(int id) throws ErrorResponse {
        List<Employee> employeesList = this.getAllEmployees();
        List<Employee> employeesF = new ArrayList<>();
        Department department;
        try {
                department = this.departmentRepository.findById(id);
                for (Employee employee : employeesList) {
                    if (employee.getDepartment().getId() == id) {
                        employeesF.add(employee);
                    }
                }
         } catch (NoSuchElementException noSuchElementException) {
                throw new ErrorResponse(noSuchElementException.getMessage());
            }catch (NullPointerException nullPointerException){
            throw new ErrorResponse(nullPointerException.getMessage()+"without department or job");
        }
        return employeesF;
    }




    public List<Employee> getEmployeesByJob(int id) throws ErrorResponse {
        List<Employee> employeesList = this.employeeRepository.findAll();
        List<Employee> employeesF = new ArrayList<>();
        JobCategory jobCategory;
        try {
            jobCategory = this.jobCategoryRepository.findById(id);
            for (Employee employee : employeesList) {
                if (employee.getJobCategory().getId() == id) {
                    employeesF.add(employee);
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            throw new ErrorResponse(noSuchElementException.getMessage());
        } catch (NullPointerException nullPointerException) {
            throw new ErrorResponse(nullPointerException.getMessage() + ": whithout department or job");
        }
        return employeesF;
    }


    public Employee updateEmployee(Employee employee, int id) {

        Employee employee1 = this.employeeRepository.findById(id).get();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setDepartment(employee.getDepartment());
        employee1.setJobCategory(employee.getJobCategory());
        employee1.setActive(employee.isActive());
        employee1.setAddress(employee.getAddress());
        employee1.setBirthday(employee.getBirthday());
        employee1.setCP(employee.getCP());
        employee1.setEmail(employee.getEmail());
        employee1.setStartDate(employee.getStartDate());
        employee1.setEndDate(employee.getEndDate());
        employee1.setHasDrivingLicense(employee.isHasDrivingLicense());
        employee1.setManager(employee.isManager());
        employee1.setNoChildren(employee.getNoChildren());
        employee1.setSalary(employee.getSalary());
        employee1.setSocialSecurityNumber(employee.getSocialSecurityNumber());
        employee1.setStudies(employee.getStudies());
        employee1.setTelephone(employee.getTelephone());

        this.employeeRepository.save(employee1);
        return employee1;

    }


}

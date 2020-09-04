package com.Ausy_Technologies.employees.Mapper;

import com.Ausy_Technologies.employees.Error.ErrorResponse;
import com.Ausy_Technologies.employees.Model.DAO.Department;
import com.Ausy_Technologies.employees.Model.DAO.Employee;
import com.Ausy_Technologies.employees.Model.DTO.EmployeeDto;
import com.Ausy_Technologies.employees.Repository.DepartmentRepository;
import com.Ausy_Technologies.employees.Repository.EmployeeRepository;
import com.Ausy_Technologies.employees.Repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
// Adnotare generica de tip Stereotype.Ii spunem contextului ca aceasta este doar o simpla componenta ( un simplu bean).
// Practic ne declaram propriul mapper ( cel care se ocupa de maparea unui User la un UserDto) !
public class EmployeeMapper {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public EmployeeDto employeeToEmployeeDTO(Employee employee) throws ErrorResponse {
        EmployeeDto employee1= new EmployeeDto();
        if (employee != null) {
            try {
                employee1.setFirstName(employee.getFirstName());
                employee1.setLastName(employee.getLastName());
                employee1.setEmail(employee.getEmail());
                employee1.setDepartment(employee.getDepartment().getNume());
                employee1.setJobCategory(employee.getJobCategory().getNume());



            } catch (NullPointerException nullPointerException) {
                throw new ErrorResponse(nullPointerException.getMessage() + "department or job category.");
            }

        }
        else {
            throw new ErrorResponse("Didn't make it");
        }
        return employee1;
    }
}


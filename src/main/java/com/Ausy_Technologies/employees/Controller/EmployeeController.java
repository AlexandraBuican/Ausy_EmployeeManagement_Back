package com.Ausy_Technologies.employees.Controller;

import com.Ausy_Technologies.employees.Error.ErrorResponse;
import com.Ausy_Technologies.employees.Mapper.EmployeeMapper;
import com.Ausy_Technologies.employees.Model.DAO.Employee;
import com.Ausy_Technologies.employees.Model.DTO.EmployeeDto;
import com.Ausy_Technologies.employees.Service.DepartmentService;
import com.Ausy_Technologies.employees.Service.EmployeeService;
import com.Ausy_Technologies.employees.Service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    @Autowired // -> dependency injection
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        Employee employeeAdded = this.employeeService.addEmployee(employee);
        return employeeAdded;
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees()
    {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/addEmployee2/{departmentId}/{jobCategoryId}")
    public ResponseEntity<Employee> addEmployee2(@RequestBody Employee employee, @PathVariable int departmentId, @PathVariable int jobCategoryId)
    {
        Employee employeeAdded;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "add dep and job for employee" );
        try{
            employeeAdded = this.employeeService.addEmployee2(employee,departmentId,jobCategoryId);
        }catch (ErrorResponse e){
            System.err.println(e);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeAdded, httpHeaders, HttpStatus.OK);

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "delete employee by id" );
        try{
            this.employeeService.deleteEmployeeById(id);
        }catch (ErrorResponse errorResponse){
            System.err.println(errorResponse);
            return new ResponseEntity<>("Not found", httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Deleted", httpHeaders, HttpStatus.OK);

    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
    {
        Employee employee1;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "get employee by id" );
        try{
            employee1 = this.employeeService.getEmployeeById(id);
        }catch (ErrorResponse errorResponse){
            System.err.println(errorResponse);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee1, httpHeaders, HttpStatus.OK);

    }
    @GetMapping("/getEmployeeDto/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeDto(@PathVariable int id) throws ErrorResponse {
        Employee employee;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "get employeeDto by id" );
        try{
            employee = this.employeeService.getEmployeeById(id);
        }catch (ErrorResponse e){
            System.err.println(e);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
        }
        EmployeeDto employee1 = this.employeeMapper.employeeToEmployeeDTO(employee);
        return new ResponseEntity<>(employee1, httpHeaders, HttpStatus.OK);


    }

    @GetMapping("/getEmployeesByDep/{id}")
    public ResponseEntity<List<Employee>> getEmployeesByDep(@PathVariable int id)
    {
        List<Employee> employeeList;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "get employee by department" );
        try{
            employeeList = this.employeeService.getEmployeesByDep(id);
        }catch (ErrorResponse errorResponse){
            System.err.println(errorResponse);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, httpHeaders, HttpStatus.OK);

    }


    @GetMapping("/getEmployeesByJob/{id}")
    public ResponseEntity<List<Employee>> getEmployeesByJob(@PathVariable int id)
    {
        List<Employee> employeeList;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "get employee by department" );
        try{
            employeeList = this.employeeService.getEmployeesByJob(id);
        }catch (ErrorResponse errorResponse){
            System.err.println(errorResponse);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, httpHeaders, HttpStatus.OK);

    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int id){
        Employee employee1;
        employee1 = employeeService.updateEmployee(employee,id);
        return employee1;
    }



}

package com.Ausy_Technologies.employees.Model.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "isManager")
    private boolean isManager;

    @Column(name = "startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startDate;


    @Column(name = "endDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    @Column(name = "active")
    private boolean active;
    @Column(name = "address")
    private String address;
    @Column(name = "CP")
    private int CP;
    @Column(name = "telephone")
    private int telephone;
    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthday;

    @Column(name = "noChildren")
    private int noChildren;
    @Column(name = "salary")
    private double salary;
    @Column(name = "studies")
    private String studies;
    @Column(name = "socialSecurityNumber")
    private int socialSecurityNumber;
    @Column(name = "hasDrivingLicense")
    private boolean hasDrivingLicense;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jobCategoryId")
    private JobCategory jobCategory;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isManager=" + isManager +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", active=" + active +
                ", address='" + address + '\'' +
                ", CP=" + CP +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", noChildren=" + noChildren +
                ", salary=" + salary +
                ", studies='" + studies + '\'' +
                ", socialSecurityNumber=" + socialSecurityNumber +
                ", hasDrivingLicense=" + hasDrivingLicense +
                ", department=" + department +
                ", jobCategory=" + jobCategory +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getNoChildren() {
        return noChildren;
    }

    public void setNoChildren(int noChildren) {
        this.noChildren = noChildren;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public boolean isHasDrivingLicense() {
        return hasDrivingLicense;
    }

    public void setHasDrivingLicense(boolean hasDrivingLicense) {
        this.hasDrivingLicense = hasDrivingLicense;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }
}

package com.Ausy_Technologies.employees.Model.DAO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId")
    private int id;
    @Column(name = "nume")
    private String nume;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department" , cascade = CascadeType.ALL)

    private List<Employee> employeeList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }


}

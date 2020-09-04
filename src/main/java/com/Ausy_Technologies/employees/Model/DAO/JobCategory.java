package com.Ausy_Technologies.employees.Model.DAO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobcategory")
public class JobCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobCategoryId")
    private int id;
    @Column(name = "nume")
    private String nume;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "jobCategory", cascade = CascadeType.ALL)
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
        return "JobCategory{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }
}

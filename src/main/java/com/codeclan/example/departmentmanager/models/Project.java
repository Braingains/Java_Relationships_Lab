package com.codeclan.example.departmentmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Double duration;

    @JsonIgnoreProperties({"projects"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "employees_projects",
            joinColumns = { @JoinColumn(
                    ////raid_id is the column with the foreign key of this class (Raid)
                    name = "project_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    //pirate_id is the foreign key of the other class (Pirate)
                    name = "employee_id",
                    nullable = false,
                    updatable = false)
            })

    private List<Employee> employees;

    public Project(String name, Double duration) {
        this.name = name;
        this.duration = duration;
        this.employees = new ArrayList<>();
    }

    public Project() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}

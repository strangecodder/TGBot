package com.backendservice.databases.backenddb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(columnDefinition = "serial")
    private int id;

    @Column(name = "tg_id")
    private long tg_id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @OneToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department_id;

    @OneToOne
    @JoinColumn(name = "state_id",referencedColumnName = "id")
    private State state_id;

    @Column(name = "email")
    private String email;
}

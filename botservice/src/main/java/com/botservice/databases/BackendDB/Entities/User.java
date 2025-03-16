package com.botservice.databases.BackendDB.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "Tg_id")
    private int Tg_id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @OneToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department_id;

    @OneToOne
    @JoinColumn(name = "state_id",referencedColumnName = "id")
    private State state_id;
}

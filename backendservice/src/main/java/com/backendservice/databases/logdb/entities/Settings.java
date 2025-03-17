package com.backendservice.databases.logdb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "settings")
@AllArgsConstructor
@NoArgsConstructor
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private String value;
}

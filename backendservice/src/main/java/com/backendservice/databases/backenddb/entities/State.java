package com.backendservice.databases.backenddb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "state")
@AllArgsConstructor
@NoArgsConstructor
public class State {

    @Id
    private Integer id;

    @Column(name = "value")
    private String value;
}

package com.backendservice.DataBases.LogDB.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "user_action")
@AllArgsConstructor
@NoArgsConstructor
public class UserAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "value")
    private String value;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "type")
    private String type;

    @OneToOne
    @JoinColumn(name = "base_id", referencedColumnName = "id")
    private BaseTable base_id;

}

package com.backendservice.databases.logdb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "message_log")
@AllArgsConstructor
@NoArgsConstructor
public class MessageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "base_id",referencedColumnName = "id")
    private BaseTable base_id;

    @Column(name = "message")
    private String message;

    @Column(name = "time")
    private Timestamp time;
}

package com.backendservice.databases.LogDB.Entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @OneToOne
    @JoinColumn(name = "base_id",referencedColumnName = "id")
    private BaseTable base_id;

    @Column(name = "message")
    private String message;

    @Column(name = "time")
    private Timestamp time;
}

package com.backendservice.databases.logdb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "base_table")
@AllArgsConstructor
@NoArgsConstructor
public class BaseTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "tg_id")
    private long tg_id;

    @Column(name = "chat_id")
    private int chat_id;
}

package com.backendservice.databases.LogDB.Entities;

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
    private int tg_id;

    @Column(name = "chat_id")
    private int chat_id;

    @Column(name = "chat_role")
    private int chat_role;
}

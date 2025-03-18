package com.backendservice.databases.backenddb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chat")
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "chat_name")
    private String chat_name;

    @Column(name = "link")
    private String link;

    @OneToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department_id;
}

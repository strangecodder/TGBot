package com.backendservice.databases.LogDB.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tag_group")
@AllArgsConstructor
@NoArgsConstructor
public class TagGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @ManyToOne
    @JoinColumn(name = "log_id",referencedColumnName = "id")
    private MessageLog log_id;


}

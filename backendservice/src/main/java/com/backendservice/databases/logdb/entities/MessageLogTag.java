package com.backendservice.databases.logdb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message_log_tag")
@AllArgsConstructor
@NoArgsConstructor
public class MessageLogTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @ManyToOne
    @JoinColumn(name = "log_id",referencedColumnName = "id")
    private MessageLog log_id;

    @ManyToOne
    @JoinColumn(name = "tag_id",referencedColumnName = "id")
    private Tag tag_id;

}

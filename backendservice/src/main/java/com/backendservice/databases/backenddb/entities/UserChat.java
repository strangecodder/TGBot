package com.backendservice.databases.backenddb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_chat")
@AllArgsConstructor
@NoArgsConstructor
public class UserChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "chat_id",referencedColumnName = "id")
    private Chat chat_id;

    @OneToOne
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    private Role role_id;

}

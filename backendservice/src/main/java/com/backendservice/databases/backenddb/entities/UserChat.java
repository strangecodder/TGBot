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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", insertable = false, updatable = false, nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Employee employee_id;

    @ManyToOne
    @JoinColumn(name = "chat_id",referencedColumnName = "id")
    private Chat chat_id;

    @OneToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role role_id;

}

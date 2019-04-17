package com.lib.training.model.entities;

import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String firstr_name;
    @Column
    private String sur_name;
    @Column
    private String second_name;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String phone;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToOne(mappedBy = "user")
    private BookUnit bookUnit;

}

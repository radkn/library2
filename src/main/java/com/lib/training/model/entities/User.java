package com.lib.training.model.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    @NotBlank(message = "First name cannot be empty!")
    private String first_name;
    @Column
    @NotBlank(message = "Surname cannot be empty!")
    private String surname;
    @Column
    private String second_name;
    @Column
    @NotBlank(message = "Email cannot be empty!")
    private String email;
    @Column
    @NotBlank(message = "Password cannot be empty!")
    private String password;
    @Transient
    private String password2;
    @Column
    @NotBlank(message = "Phone cannot be empty!")
    private String phone;
    @Column
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToOne(mappedBy = "user" )
    private BookUnit bookUnit;


    public User(){

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}

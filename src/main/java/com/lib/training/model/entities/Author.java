package com.lib.training.model.entities;



import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;
    @Column
    private String second_name;
    @Column
    private String surname;


    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}

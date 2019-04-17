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
    private String first_name;
    @Column
    private String second_name;
    @Column
    private String sur_name;


    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}

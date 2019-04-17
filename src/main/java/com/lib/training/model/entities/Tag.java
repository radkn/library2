package com.lib.training.model.entities;

import lombok.Data;
import org.hibernate.validator.constraints.EAN;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String tag;

    @ManyToMany(mappedBy = "tags")
    private List<Book> books;


}

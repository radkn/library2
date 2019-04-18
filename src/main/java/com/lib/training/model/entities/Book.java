package com.lib.training.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Data
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    @NotBlank(message = "Book title cannot be empty!")
    private String title;
    @Column
    private String description;
    @Column
    private int total_amount;
    @Column
    private int amount_of_free;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    //@NotBlank(message = "Author cannot be empty!")
    private List<Author> authors;

    @OneToOne(mappedBy = "book")
    private BookUnit bookUnit;

    @ManyToMany
    @JoinTable(name="book_tag",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

}

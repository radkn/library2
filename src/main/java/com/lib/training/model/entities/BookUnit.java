package com.lib.training.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@Entity
@Table(name = "bookunit")
public class BookUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @Column
    private Timestamp status_change_date;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column
    private Integer shelf_address;

    public BookUnit(Book book) {
        this.book = book;
        this.status_change_date = new Timestamp(System.currentTimeMillis());
    }
}

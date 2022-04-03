package com.tarun.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "book")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;
    @Column(name = "BOOK_NAME")
    String bookName;
    @Column(name = "BOOK_SUBNAME")
    String bookSubname;
    @Column(name = "BOOK_SERIAL_NAME")
    String serialName;
    @Column(name = "BOOK_AUTHOR")
    String booksAuthor;
    @Column(name = "BOOK_PUBLISHER")
    String booksPublisher;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "ISBN")
    String isbn;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSubname() {
        return bookSubname;
    }

    public void setBookSubname(String bookSubname) {
        this.bookSubname = bookSubname;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public String getBooksAuthor() {
        return booksAuthor;
    }

    public void setBooksAuthor(String booksAuthor) {
        this.booksAuthor = booksAuthor;
    }

    public String getBooksPublisher() {
        return booksPublisher;
    }

    public void setBooksPublisher(String booksPublisher) {
        this.booksPublisher = booksPublisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

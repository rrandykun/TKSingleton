package com.graphicacode;

public class Book {
    int book_id;
    String book_name;
    String book_code;
    String date_in;
    String status;

    public Book() {
    }

    public Book(String book_name, String book_code) {
        this.book_name = book_name;
        this.book_code = book_code;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book [book_id=" + book_id + ",book_name=" + book_name + ", book_code=" + book_code + ",status=" + status + "]";
    }
}
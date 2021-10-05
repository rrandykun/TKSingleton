package com.graphicacode;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class App {
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) throws SQLException{
        BookDaoImplementation bookDao = new BookDaoImplementation();

        Scanner input = new Scanner (System.in);

        System.out.println ("         Menu          ");
        System.out.println ("-------------------------------");
        System.out.println   ("1. Data Buku");
        System.out.println   ("2. Data Peminjam");
        System.out.println   ("3. Peminjaman Buku");
        System.out.println   ("4. Pengembalian Buku");
        System.out.print   ("Pilih menu     : ");
        int jumlah = input.nextInt();
        System.out.println ();

//        //add
//        Book book = new Book();
////        book.setBook_name("Buku Sejarah");
////        book.setBook_code("00001");
////        book.setStatus("available");
////        bookDao.add(book);
//
//        //update
//        Book tempBook = bookDao.getBook("00001");
//        tempBook.setStatus("rent");
//        bookDao.update(tempBook);
//
//        //delete
//        //bookDao.delete("00002");
//
//        //select
//        List<Book> ls = bookDao.getBooks();
//        for (Book allbook : ls) {
//            System.out.println(allbook);
//        }
    }
    
}
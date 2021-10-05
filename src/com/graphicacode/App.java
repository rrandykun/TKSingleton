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
        int menu;
        do {
            System.out.println();
            System.out.println ("         Menu          ");
            System.out.println ("-------------------------------");
            System.out.println   ("1. Data Buku");
            System.out.println   ("2. Data Peminjam");
            System.out.println   ("3. Peminjaman Buku");
            System.out.println   ("4. Pengembalian Buku");
            System.out.print   ("Pilih menu     : ");
            menu = input.nextInt();
            System.out.println ();

            switch (menu){
                case 1:
                    System.out.println ("         Menu Data Buku          ");
                    System.out.println ("-------------------------------");
                    System.out.println   ("1. Tambah Buku");
                    System.out.println   ("2. Update Buku");
                    System.out.println   ("3. Hapus Buku");
                    System.out.println   ("4. Lihat Buku");
                    System.out.print   ("Pilih menu     : ");
                    int menuBuku = input.nextInt();
                    String judul, kode;
                    List<Book> ls;

                    System.out.println ();
                    input.nextLine();
                    switch (menuBuku){
                        case 1:


                            System.out.println ("         Tambah Data Buku          ");
                            System.out.println ("-------------------------------");
                            System.out.print   ("Masukkan Judul Buku: ");
                            judul = input.nextLine();
                            System.out.print   ("Masukkan Kode Buku: ");
                            kode = input.next();

                            //eksekusi add
                            Book book = new Book();
                            book.setBook_name(judul);
                            book.setBook_code(kode);
                            book.setStatus("available");
                            bookDao.add(book);
                            break;
                        case 2:
                            ls = bookDao.getBooks();
                            for (Book allbook : ls) {
                                System.out.println(allbook);
                            }
                            System.out.println("== Ubah data buku == ");
                            Scanner update = new Scanner(System.in);
                            System.out.print("Masukkan kode buku: ");
                            String bookcodeup= update.nextLine();
                            System.out.print("Masukkan judul buku: ");
                            String booknameup = update.nextLine();
                            System.out.print("Masukkan status buku: ");
                            String status = update.next();

                            bookDao.update(booknameup,bookcodeup, status);
                            break;
                        case 3:
                            ls = bookDao.getBooks();
                            for (Book allbook : ls) {
                                System.out.println(allbook);
                            }
                            System.out.print   ("Masukkan Kode Buku yang mau dihapus: ");
                            kode = input.next();

                            bookDao.delete(kode);
                            break;
                        case 4:
                            ls = bookDao.getBooks();
                            for (Book allbook : ls) {
                                System.out.println(allbook);
                            }
                            break;
                        default:
                    }
                    break;
                default:

            }
            input.nextLine();
            System.out.print("Kembali ke menu utama [y/n] ? ");
        } while (input.next().equalsIgnoreCase("y"));
        input.close();
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
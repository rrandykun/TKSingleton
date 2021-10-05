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
        UserDaoImplementation userDao = new UserDaoImplementation();

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
                case 2:
                    User user = new User();

                    System.out.println ("         Menu Data User          ");
                    System.out.println ("-------------------------------");
                    System.out.println   ("1. Tambah User");
                    System.out.println   ("2. Update User");
                    System.out.println   ("3. Hapus User");
                    System.out.println   ("4. Lihat User");
                    System.out.print   ("Pilih menu     : ");
                    int menuUser = input.nextInt();
                    System.out.println ();
                    List<User> ls_user;

                    switch (menuUser){
                        case 1:
                            input.nextLine();

                            System.out.println ("         Tambah Data Peminjam          ");
                            System.out.println ("-------------------------------");
                            System.out.print   ("Masukkan Nama Peminjam: ");
                            String nama = input.next();

                            //add
                            user.setNama_peminjam(nama);
                            user.setStatus("Active");
                            userDao.add(user);
                            break;
                        case 2:
                            //update
                            ls_user = userDao.getUsers();
                            for (User alluser : ls_user) {
                                System.out.println(alluser);
                            }
                            System.out.println("== Ubah data Peminjam == ");
                            Scanner update = new Scanner(System.in);
                            System.out.print("Masukkan id Peminjam: ");
                            String id_user= update.nextLine();
                            System.out.print("Masukkan nama peminjam: ");
                            String nama_peminjam= update.nextLine();
                            System.out.print("Masukkan status peminjam: ");
                            String status = update.next();

                            int user_id = Integer.parseInt(id_user);

                            userDao.update(nama_peminjam, status,user_id);

                            break;
                        case 3:
                            //delete
                            System.out.print   ("Masukkan Id User: ");
                            int id = input.nextInt();
                            System.out.println ();

                            userDao.delete(id);

                            break;
                        case 4:
                            //view
                            ls_user = userDao.getUsers();
                            for (User allUser : ls_user) {
                                System.out.printf("ID : %s | Nama Peminjam : %s | Status : %s",allUser.getUser_id(),allUser.getNama_peminjam(), allUser.getStatus());
                                System.out.println();
                            }

                            break;
                        case 5:
                            System.exit(0);
                        default:
                    }

                    break;
                case 3:
                    System.out.println ("         Peminjaman Buku          ");
                    System.out.println ("----------------------------------");
                    Scanner rent = new Scanner(System.in);
                    System.out.print   ("Masukkan Kode Buku: ");
                    String bookcodeup= rent.next();
                    System.out.print("Masukkan ID peminjam: ");
                    String userrent= rent.next();
                    bookDao.rentBook(bookcodeup, userrent);
                    break;
                case 4:
                    System.out.println ("         Pengembalian Buku          ");
                    System.out.println ("------------------------------------");
                    Scanner returnBook = new Scanner(System.in);
                    System.out.print("Masukkan Kode Buku: ");
                    String bookcodereturn= returnBook.next();
                    System.out.print("Masukkan Kode Peminjaman: ");
                    String id_pinjam= returnBook.next();
                    bookDao.returnBook(bookcodereturn, id_pinjam);
                    break;
                default:

            }
            input.nextLine();
            System.out.print("Kembali ke menu utama [y/n] ? ");
        } while (input.next().equalsIgnoreCase("y"));
        input.close();
    }
    
}
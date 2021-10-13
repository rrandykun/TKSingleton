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
        TransaksiDaoImplementation transDao = new TransaksiDaoImplementation();

        Scanner input = new Scanner (System.in);
        //System.out.print   ("Masukkan Nama Petugas: ");
        //String namaPetugas = input.nextLine();

        int menu;
        do {
           // System.out.println("Nama Petugas = " + namaPetugas);
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
                    String judul, penerbit;
                    int tahun, kode;
                    List<Book> ls;

                    System.out.println ();
                    input.nextLine();
                    switch (menuBuku){
                        case 1:
                            System.out.println ("         Tambah Data Buku          ");
                            System.out.println ("-------------------------------");
                            System.out.print   ("Masukkan Judul Buku: ");
                            judul = input.nextLine();
                            System.out.print   ("Masukkan Penerbit Buku: ");
                            penerbit = input.nextLine();
                            System.out.print   ("Masukkan Tahun Buku: ");
                            tahun = input.nextInt();


                            //eksekusi add
                            Book book = new Book();
                            book.setJudul(judul);
                            book.setPenerbit(penerbit);
                            book.setTahun(tahun);
                            book.setStatus("available");
                            bookDao.add(book);
                            break;
                        case 2:
                            ls = bookDao.getBooks();
                            for (Book allbook : ls) {
                                System.out.println(allbook);
                            }

                            if(ls.size()>0){
                                Scanner update = new Scanner(System.in);

                                System.out.println("== Ubah data buku == ");
                                System.out.print("Masukkan kode buku: ");
                                int kdBuku = update.nextInt();

                                Book bp = bookDao.getBook(kdBuku);

                                if(bp != null){
                                    update.nextLine();
                                    System.out.print("Masukkan judul buku: ");
                                    String booknameup = update.nextLine();
                                    System.out.print("Masukkan penerbit buku: ");
                                    String penerbitup = update.nextLine();
                                    System.out.print("Masukkan tahun buku: ");
                                    int tahunup = update.nextInt();
                                    System.out.print("Masukkan status buku: ");
                                    String status = update.next();

                                    bookDao.update(kdBuku, booknameup, penerbitup, tahunup, status);
                                }else{
                                    System.out.println("Kode buku tidak ditemukan.");
                                }
                            }
                            break;
                        case 3:
                            ls = bookDao.getBooks();
                            for (Book allbook : ls) {
                                System.out.println(allbook);
                            }
                            if(ls.size()>0){
                                System.out.print   ("Masukkan Kode Buku yang mau dihapus: ");
                                kode = input.nextInt();

                                bookDao.delete(kode);
                            }

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
                    String nama, notelp, email;
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
                            nama = input.nextLine();
                            System.out.print("Masukkan no telepon peminjam: ");
                            notelp = input.nextLine();
                            System.out.print("Masukkan email peminjam: ");
                            email = input.nextLine();
                            //add
                            user.setNama_peminjam(nama);
                            user.setNoTelp(notelp);
                            user.setEmail(email);
                            userDao.add(user);
                            break;
                        case 2:
                            //update
                            ls_user = userDao.getUsers();
                            for (User alluser : ls_user) {
                                System.out.println(alluser);
                            }

                            if(ls_user.size()>0){
                                Scanner update = new Scanner(System.in);

                                System.out.println("== Ubah data Peminjam == ");
                                System.out.print("Masukkan id Peminjam: ");
                                int id_user= update.nextInt();

                                User us = userDao.getUser(id_user);

                                if(us != null){
                                    update.nextLine();
                                    System.out.print("Masukkan nama peminjam: ");
                                    nama = update.nextLine();
                                    System.out.print("Masukkan no telepon peminjam: ");
                                    notelp = update.nextLine();
                                    System.out.print("Masukkan email peminjam: ");
                                    email = update.nextLine();

                                    userDao.update(id_user, nama, notelp, email);
                                }else{
                                    System.out.println("ID peminjam tidak ditemukan.");
                                }
                            }
                            break;
                        case 3:
                            //delete
                            ls_user = userDao.getUsers();
                            for (User allUser : ls_user) {
                                System.out.printf("ID : %s | Nama Peminjam : %s | No Telp : %s | Email : %s",allUser.getUser_id(),allUser.getNama_peminjam(), allUser.getNoTelp(), allUser.getEmail());
                                System.out.println();
                            }

                            if(ls_user.size()>0){
                                System.out.print   ("Masukkan Id User: ");
                                int id = input.nextInt();
                                System.out.println ();

                                userDao.delete(id);
                            }



                            break;
                        case 4:
                            //view
                            ls_user = userDao.getUsers();
                            for (User allUser : ls_user) {
                                System.out.printf("ID : %s | Nama Peminjam : %s | No Telp : %s | Email : %s",allUser.getUser_id(),allUser.getNama_peminjam(), allUser.getNoTelp(), allUser.getEmail());
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
                    int kdBuku = rent.nextInt();

                    Book bp = bookDao.getBook(kdBuku);

                    if(bp != null){
                        if (bp.status.equals("rent")) {
                            System.out.println("Buku sedang dipinjam.");
                        }else{
                            System.out.println("Judul buku: " + bp.judul + " \nStatus: " + bp.status);
                            rent.nextLine();
                            System.out.print("Masukkan ID peminjam: ");
                            int userrent= rent.nextInt();
                            User us = userDao.getUser(userrent);
                            if(us != null){
                                System.out.println("Nama peminjam : " + us.getNama_peminjam());
                                rent.nextLine();
                                System.out.print("Masukkan tanggal peminjaman [dd/mm/yyyy]: ");
                                String tgl= rent.nextLine();

                                transDao.rentBook(kdBuku, userrent, tgl);
                            }else{
                                System.out.println("ID peminjam tidak ditemukan.");
                            }

                        }
                    }else{
                        System.out.println("Kode buku tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.println ("         Pengembalian Buku          ");
                    System.out.println ("------------------------------------");
                    Scanner returnBook = new Scanner(System.in);
                    System.out.print("Masukkan ID peminjam: ");
                    int peminjam= returnBook.nextInt();
                    List<Transaksi> ls_trans;

                    ls_trans = transDao.getRents(peminjam);
                    if (ls_trans != null){
                        for (Transaksi allTrx : ls_trans) {
                            System.out.printf("ID Transaksi: %s | Kode Buku : %s | Tanggal Pinjam : %s",allTrx.getId(), allTrx.getKdBuku(), allTrx.getTglPinjam());
                            System.out.println();
                        }
                        System.out.println();
                        System.out.print("Masukkan Kode Buku: ");
                        int bookcodereturn = returnBook.nextInt();
                        System.out.print("Masukkan tanggal pengembalian [dd/mm/yyyy]: ");
                        String tglKembali = returnBook.next();
                        transDao.returnBook(peminjam, bookcodereturn, tglKembali);
                    }else{
                        System.out.println("ID peminjam tidak ditemukan dalam transaksi.");
                    }
                    break;
                default:

            }
            input.nextLine();
            System.out.print("Kembali ke menu utama [y/n] ? ");
        } while (input.next().equalsIgnoreCase("y"));
        input.close();
    }
    
}
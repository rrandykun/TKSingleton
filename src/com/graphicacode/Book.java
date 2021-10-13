package com.graphicacode;

public class Book {
    int kdBuku;
    String judul;
    String penerbit;
    int tahun;
    String status;

    public Book() {
    }

    public Book(String judul, String penerbit, int tahun, String status) {
        this.judul = judul;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.status = status;
    }

    public int getkdBuku() {
        return kdBuku;
    }

    public void setkdBuku(int kdBuku) {
        this.kdBuku = kdBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book [kdBuku=" + kdBuku + ", judul=" + judul + ", penerbit=" + penerbit +", tahun=" + tahun + ", status=" + status + "]";
    }
}
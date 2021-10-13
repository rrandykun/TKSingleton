package com.graphicacode;

public class Transaksi {
    String tglPinjam;
    String tglKembali;
    int id;
    int kdBuku;
    int idUser;

    public Transaksi(){

    }

    public Transaksi(int idUser, int kdBuku, String tglPinjam,String tglKembali) {
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.idUser = idUser;
        this.kdBuku = kdBuku;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setKdBuku(int kdBuku) {
        this.kdBuku = kdBuku;
    }

    public int getKdBuku() {
        return kdBuku;
    }

    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public String getTglPinjam() {
        return tglPinjam;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    @Override
    public String toString() {
        return "Transaksi [ID Transaksi=" + id + ", ID User=" + idUser + ", Kode Buku=" + kdBuku +", Tanggal Pinjam=" + tglPinjam + ", Tanggal Kembali=" + tglKembali + "]";
    }
}

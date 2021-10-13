package com.graphicacode;

public class Pustakawan {
    int idPetugas;
    String namaPetugas;

    public Pustakawan() {
    }

    public Pustakawan(String nama) {
        this.namaPetugas = nama;
    }

    public int getUser_id() {
        return idPetugas;
    }

    public void setUser_id(int user_id) {
        this.idPetugas = user_id;
    }

    public String getNama_peminjam() {
        return namaPetugas;
    }

    public void setNama_peminjam(String nama) {
        this.namaPetugas = nama;
    }

    @Override
    public String toString() {
        return "Petugas" + namaPetugas ;
    }
}

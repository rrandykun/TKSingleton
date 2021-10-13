package com.graphicacode;

public class User {
    int user_id;
    String nama_peminjam;
    String notelp;
    String email;

    public User() {
    }

    public User(String nama, String notelp, String email) {
        this.nama_peminjam = nama;
        this.notelp = notelp;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNama_peminjam() {
        return nama_peminjam;
    }

    public void setNama_peminjam(String nama) {
        this.nama_peminjam = nama;
    }

    public String getNoTelp() {
        return notelp;
    }

    public void setNoTelp(String notelp) {
        this.notelp = notelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ",nama_peminjam=" + nama_peminjam + ", notelp=" + notelp+ ", email=" + email +"]";
    }
}

package com.graphicacode;

public class User {
    int user_id;
    String nama_peminjam;
    String status;

    public User() {
    }

    public User(String nama, String status) {
        this.nama_peminjam = nama;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ",nama_peminjam=" + nama_peminjam + ", status=" + status+ "]";
    }
}

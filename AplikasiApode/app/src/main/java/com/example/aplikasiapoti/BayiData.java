package com.example.aplikasiapoti;

public class BayiData {

    private String nik_pasien;
    private String nama_pasien;
    private String tanggal_lahir;
    private String alamat;
    private String created_at;
    private String updated_at;
    private int kategori_id;


    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getNik_pasien() {
        return nik_pasien;
    }

    public void setNik_pasien(String nik_pasien) {
        this.nik_pasien = nik_pasien;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_t) {
        this.updated_at = updated_t;
    }
}

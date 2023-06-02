package com.example.aplikasiapoti;

public class PostRequestApi {

    private String nik;
    private int tinggi_badan;
    private int berat_badan;
    private String lab;
    private int lingkar_perut;


    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public int getTinggi_badan() {
        return tinggi_badan;
    }

    public void setTinggi_badan(int tinggi_badan) {
        this.tinggi_badan = tinggi_badan;
    }

    public int getBerat_badan() {
        return berat_badan;
    }

    public void setBerat_badan(int berat_badan) {
        this.berat_badan = berat_badan;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public int getLingkar_perut() {
        return lingkar_perut;
    }

    public void setLingkar_perut(int lingkar_perut) {
        this.lingkar_perut = lingkar_perut;
    }
}

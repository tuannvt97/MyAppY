package com.example.myappy;

import java.io.Serializable;

public class Thietbi implements Serializable {
    private String name;
    private String ma;
    private String matkhau;
    private int hinh;

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public Thietbi(String name, String ma, String matkhau, int hinh) {
        this.name = name;
        this.ma = ma;
        this.matkhau = matkhau;
        this.hinh = hinh;
    }

    public Thietbi() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }


    @Override
    public String toString() {
        return this.name + this.ma;
    }
}
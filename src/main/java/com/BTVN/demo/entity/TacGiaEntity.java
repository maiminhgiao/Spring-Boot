package com.BTVN.demo.entity;


import jakarta.persistence.*;

@Entity(name = "tacgia")
public class TacGiaEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "id")
    private int id;
    @Column (name = "ten_tac_gia")
    private String tenTacGia;
    @Column (name = "ho_ten")
    private String hoTen;
    @Column (name = "gioi_tinh")
    private char gioiTinh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public char getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(char gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}

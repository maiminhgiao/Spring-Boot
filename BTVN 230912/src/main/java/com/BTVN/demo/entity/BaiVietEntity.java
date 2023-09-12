package com.BTVN.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity (name = "baiviet")
public class BaiVietEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "id")
    private int id;

    @Column (name = "tieu_de")
    private String tieuDe;
    @Column (name = "noi_dung")
    private String noiDung;

    @Column (name="id_tac_gia")
    private int idTacGia;
    @Column (name = "ngay_viet")
    private Date ngayViet;

    public int getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(int idTacGia) {
        this.idTacGia = idTacGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayViet() {
        return ngayViet;
    }

    public void setNgayViet(Date ngayViet) {
        this.ngayViet = ngayViet;
    }

    public Date setNgayViet() {
        return null;
    }

    public String setTieuDe() {
        return null;}
}

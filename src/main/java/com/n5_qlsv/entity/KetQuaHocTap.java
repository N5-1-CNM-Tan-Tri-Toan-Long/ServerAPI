package com.n5_qlsv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_kqht")
public class KetQuaHocTap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kqht")
    private long maKQHT;

    @Column(name = "mo_ta")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String moTa;

    @Column(name = "xep_loai")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String xepLoai;

    @Column(name = "diem_chu")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String diemChu;

    @Column(name = "diem_tk1")
    private Double diemTK1;

    @Column(name = "diem_tk2")
    private Double diemTK2;

    @Column(name = "diem_tk3")
    private Double diemTK3;

    @Column(name = "diem_th1")
    private Double diemTH1;

    @Column(name = "diem_th2")
    private Double diemTH2;

    @Column(name = "diem_he4")
    private Double diemHe4;

    @Column(name = "diem_he10")
    private Double diemHe10;

    @Column(name = "diem_gk")
    private Double diemGK;

    @Column(name = "diem_ck")
    private Double diemCK;

    @ManyToOne
    @JoinColumn(name = "ma_lhp")
    private LopHocPhan lopHocPhan;

    @ManyToOne
    @JoinColumn(name = "ma_sv")
    private SinhVien sinhVien;
}
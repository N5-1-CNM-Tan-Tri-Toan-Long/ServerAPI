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
    private double diemTK1;

    @Column(name = "diem_tk2")
    private double diemTK2;

    @Column(name = "diem_tk3")
    private double diemTK3;

    @Column(name = "diem_th")
    private double diemTH;

    @Column(name = "diem_he4")
    private double diemHe4;

    @Column(name = "diem_he10")
    private double diemHe10;

    @Column(name = "diem_gk")
    private double diemGK;

    @Column(name = "diem_ck")
    private double diemCK;

    @ManyToOne
    @JoinColumn(name = "ma_pdklhp")
    private PhieuDangKyLHP pdklhp;
}
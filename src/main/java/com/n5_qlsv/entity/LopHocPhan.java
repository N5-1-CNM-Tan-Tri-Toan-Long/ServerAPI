package com.n5_qlsv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_lophocphan")
public class LopHocPhan {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ma_lhp")
    private long maLHP;

    @Column(name = "ten_lhp")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String tenLHP;

    @Column(name = "mo_ta")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String moTa;

    @Column(name = "ten_viet_tat")
    private String tenVietTat;

    @Column(name = "trang_thai")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String trangThai;

    @Column(name = "so_nhom_th")
    private int soNhomTH;

    @Column(name = "so_luong_dang_ky_hien_tai")
    private int soLuongDangKyHienTai;

    @Column(name = "so_luong_dang_ky_toi_da")
    private int soLuongDangKyToiDa;

    @ManyToOne
    @JoinColumn(name = "ma_hk")
    private HocKy hocKy;

    @ManyToOne
    @JoinColumn(name = "ma_hp")
    private HocPhan hocPhan;

    @OneToMany(mappedBy = "lopHocPhan", cascade = CascadeType.ALL)
    private List<ChiTietLopHocPhan> chiTietLopHocPhanList;

    public LopHocPhan(long maLHP) {
        this.maLHP = maLHP;
    }
}

package com.n5_qlsv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_chitietlophocphan")
public class ChiTietLopHocPhan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ctlhp")
    private long maCTLHP;

    @Column(name = "lich_hoc")
    private String lichHoc;

    @Column(name = "mo_ta")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String moTa;

    @Column(name = "ten_gv")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String tenGV;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "so_phong")
    private String soPhong;

    @Column(name = "day_nha")
    private String dayNha;

    @OneToMany(mappedBy = "chiTietLopHocPhan")
    private List<PhieuDangKyLHP> phieuDangKyLHPList;

    @ManyToOne
    @JoinColumn(name = "ma_lhp")
    private LopHocPhan lopHocPhan;

    public ChiTietLopHocPhan(long maCTLHP) {
        this.maCTLHP = maCTLHP;
    }
}

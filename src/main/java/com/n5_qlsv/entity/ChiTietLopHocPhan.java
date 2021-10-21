package com.n5_qlsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    @Column(name = "mo_ta")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String moTa;

    @Column(name = "phong")
    private String phong;

    @Column(name = "day_nha")
    private String dayNha;

    @Column(name = "co_so")
    private String coSo;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @Column(name = "tiet_hoc")
    private String tietHoc;

    @ManyToOne
    @JoinColumn(name = "ma_gv")
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "ma_lhp")
    private LopHocPhan lopHocPhan;

    @JsonIgnore
    @OneToMany(mappedBy = "chiTietLopHocPhan")
    private List<LichHocSinhVien> lichHocSinhVienList;

}

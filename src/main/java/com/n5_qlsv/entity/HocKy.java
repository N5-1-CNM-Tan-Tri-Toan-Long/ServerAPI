package com.n5_qlsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tbl_hocky")
public class HocKy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hk")
    private long maHK;

    @Column(name = "mo_ta")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String moTa;

    @Column(name = "nam_bat_dau")
    private int namBatDau;

    @Column(name = "nam_ket_thuc")
    private int namKetThuc;

    @Column(name = "thu_tu_hocky")
    private int thuTuHocKy;

    @OneToMany(mappedBy = "hocKy")
    @JsonIgnore
    private List<SinhVien> sinhVienList;

    @OneToMany(mappedBy = "hocKy")
    @JsonIgnore
    private List<LopHocPhan> lopHocPhanList;
}

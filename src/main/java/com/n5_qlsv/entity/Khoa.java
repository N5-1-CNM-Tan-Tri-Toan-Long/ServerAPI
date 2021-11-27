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
@Table(name = "tbl_khoa")
public class Khoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khoa")
    private long maKhoa;

    @Column(name = "ten_khoa")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String tenKhoa;

    @Column(name = "mo_ta")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String moTa;

    @OneToMany(mappedBy = "khoa")
    @JsonIgnore
    private List<SinhVien> sinhVienList;

    @OneToMany(mappedBy = "khoa")
    @JsonIgnore
    private List<GiangVien> giangVienList;

    @JsonIgnore
    @OneToMany(mappedBy = "khoa")
    private List<ChuyenNganh> chuyenNganhList;

    @JsonIgnore
    @OneToMany(mappedBy = "khoa")
    private List<MonHoc> monHocList;
}

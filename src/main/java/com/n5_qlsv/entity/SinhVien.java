package com.n5_qlsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_sinhvien")
public class SinhVien {

    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "com.n5_qlsv.entity.SinhVienGenerator")
    @Column(name = "ma_sv")
    private String maSV;

    @Column(name = "ten_sv")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String tenSV;

    @Column(name = "email")
    private String email;

    @Column(name = "gioi_tinh")
    private boolean gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "ngay_vao_truong")
    @CreationTimestamp
    private Date ngayVaoTruong;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "so_cmnd")
    private String soCMND;

    @Column(name = "bac_dao_tao")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String bacDaoTao;

    @Column(name = "dia_chi")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String diaChi;

    @Column(name = "role_name")
    private String roleName;

    private String password;

    @ManyToOne
    @JoinColumn(name = "ma_khoa")
    private Khoa khoa;

    @ManyToOne
    @JoinColumn(name = "lop_hoc")
    private LopHoc lopHoc;

    @ManyToOne
    @JoinColumn(name = "ma_chuyen_nganh")
    private ChuyenNganh chuyenNganh;

    @JsonIgnore
    @OneToMany(mappedBy = "sinhVien")
    private List<KetQuaHocTap> ketQuaHocTapList;

    @JsonIgnore
    @OneToMany(mappedBy = "sinhVien")
    private List<LichHocSinhVien> lichHocSinhVienList;
}
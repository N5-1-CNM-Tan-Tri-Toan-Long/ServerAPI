package com.n5_qlsv.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_sinhvien")
public class SinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sv")
    private long maSV;

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

    @ManyToOne
    @JoinColumn(name = "ma_khoa")
    private Khoa khoa;

    @ManyToOne
    @JoinColumn(name = "ma_hk")
    private HocKy hocKy;

    @ManyToOne
    @JoinColumn(name = "lop_hoc")
    private LopHoc lopHoc;

    @OneToOne(mappedBy = "sinhVien",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private User user;

    public SinhVien(long maSV) {
        this.maSV = maSV;
    }
}
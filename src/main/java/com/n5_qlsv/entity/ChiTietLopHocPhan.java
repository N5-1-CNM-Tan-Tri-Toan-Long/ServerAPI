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

    @Column(name = "mo_ta_lich_hoc")
    private String moTaLichHoc;

    @Column(name = "mo_ta")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String moTa;

    @Column(name = "phong")
    private String phong;

    @Column(name = "day_nha")
    private String dayNha;

    @Column(name = "nhom_th")
    private int nhomTH;

    @ManyToOne
    @JoinColumn(name = "ma_gv")
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "ma_lhp")
    private LopHocPhan lopHocPhan;
}

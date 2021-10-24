package com.n5_qlsv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_lichhoc_sinhvien")
public class LichHocSinhVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_lhsv")
    private long maLHSV;

    @ManyToOne
    @JoinColumn(name = "ma_ctlhp")
    private ChiTietLopHocPhan chiTietLopHocPhan;

    @ManyToOne
    @JoinColumn(name = "ma_sv")
    private SinhVien sinhVien;
}

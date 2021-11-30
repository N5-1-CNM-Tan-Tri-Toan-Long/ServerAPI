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
@Table(name = "tbl_hocphankhung")
public class HocPhanKhung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maHPK;

    private Integer soTietLT, soTietTH, thuTuHocKy;

    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "ma_hp")
    private HocPhan hocPhan;
}

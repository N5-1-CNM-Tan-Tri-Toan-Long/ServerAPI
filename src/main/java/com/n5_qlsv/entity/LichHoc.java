package com.n5_qlsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_lichhoc")
public class LichHoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_lich_hoc")
    private long maLichHoc;

    @Column(name = "phong")
    private String phong;

    @Column(name = "so_tiet")
    private String soTiet;

    @Column(name = "ten_gv")
    private String tenGV;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "ma_lhp")
    private LopHocPhan lopHocPhan;

    @JsonIgnore
    @OneToMany(mappedBy = "lichHoc")
    private List<LichHocSinhVien> lichHocSinhVienList;
}

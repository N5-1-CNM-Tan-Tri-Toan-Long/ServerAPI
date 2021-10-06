package com.n5_qlsv.entity;

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
@Table(name = "tbl_hocphan")
public class HocPhan {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hp")
    private long maHocPhan;

    @Column(name = "hoc_phan_bat_buoc")
    private boolean hocPhanBatBuoc;

    @Column(name = "so_tc_lt")
    private int soTCLT;

    @Column(name = "so_tc_th")
    private int soTCTH;

    @ManyToOne
    @JoinColumn(name = "ma_mh")
    private MonHoc monHoc;

    @OneToMany(mappedBy = "hocPhan")
    private List<LopHocPhan> lopHocPhanList;

    public HocPhan(long maHocPhan) {
        this.maHocPhan = maHocPhan;
    }
}

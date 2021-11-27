package com.n5_qlsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "com.n5_qlsv.entity.HocPhanGenerator")
    @Column(name = "ma_hp")
    private String maHocPhan;

    @Column(name = "hoc_phan_bat_buoc")
    private boolean hocPhanBatBuoc;

    @Column(name = "so_tc_lt")
    private int soTCLT;

    @Column(name = "so_tc_th")
    private int soTCTH;

//    @OneToOne
//    @JoinColumn(name = "ma_mh")
//    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "ma_mh")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "ma_chuyen_nganh")
    private ChuyenNganh chuyenNganh;

    @JsonIgnore
    @OneToMany(mappedBy = "hocPhan", cascade = CascadeType.ALL)
    private List<LopHocPhan> lopHocPhanList;
}

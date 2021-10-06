package com.n5_qlsv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_phieudangkylhp")
public class PhieuDangKyLHP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_pdklhp")
    private long maPDKLHP;

    @Column(name = "ngay_dang_ky")
    @CreationTimestamp
    private Date ngayDangKy;

    @ManyToOne
    @JoinColumn(name = "ma_sv")
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "ma_ctlhp")
    private ChiTietLopHocPhan chiTietLopHocPhan;

    @OneToMany(mappedBy = "pdklhp")
    private List<KetQuaHocTap> ketQuaHocTapList;

    public PhieuDangKyLHP(long maPDKLHP) {
        this.maPDKLHP = maPDKLHP;
    }
}

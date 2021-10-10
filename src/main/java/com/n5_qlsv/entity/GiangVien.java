package com.n5_qlsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tbl_giangvien")
public class GiangVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_gv")
    private long maGV;

    @Column(name = "ten_gv")
    private String tenGV;

    @Column(name = "gioi_tinh")
    private boolean gioiTinh;

    @CreationTimestamp
    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "ma_khoa")
    private Khoa khoa;

    @JsonIgnore
    @OneToMany(mappedBy = "giangVien")
    private List<ChiTietLopHocPhan> chiTietLopHocPhanList;
}

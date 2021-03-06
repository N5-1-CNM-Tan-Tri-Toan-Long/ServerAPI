package com.n5_qlsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_chuyennganh")
public class ChuyenNganh {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ma_chuyen_nganh")
    private long maChuyenNganh;

    @Column(name = "ten_chuyen_nganh")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String tenChuyenNganh;

    @Column(name = "so_tc")
    private int soTC;

    @ManyToOne
    @JoinColumn(name = "ma_khoa")
    private Khoa khoa;

    @JsonIgnore
    @OneToMany(mappedBy = "chuyenNganh")
    private List<HocPhan> hocPhanList;

    @JsonIgnore
    @OneToMany(mappedBy = "chuyenNganh")
    private List<SinhVien> sinhVienList;
}

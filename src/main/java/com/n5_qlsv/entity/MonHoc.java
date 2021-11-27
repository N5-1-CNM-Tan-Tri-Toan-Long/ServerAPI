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
@Table(name = "tbl_monhoc")
public class MonHoc {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ma_mh")
    private long maMonHoc;

    @Column(name = "ten_mon_hoc")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String tenMonHoc;

    @Column(name = "mo_ta")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "ma_khoa")
    private Khoa khoa;

    @JsonIgnore
    @OneToOne(mappedBy = "monHoc",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private HocPhan hocPhan;
}

package com.n5_qlsv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_lophoc")
public class LopHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_lop")
    private long maLop;

    @Column(name = "ten_lop")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String tenLop;

    @OneToMany(mappedBy = "lopHoc")
    @JsonIgnore
    private List<SinhVien> sinhVienList;

    public LopHoc(long maLop) {
        this.maLop = maLop;
    }
}

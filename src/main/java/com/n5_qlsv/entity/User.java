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
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "ma_sv")
    private SinhVien sinhVien;
}

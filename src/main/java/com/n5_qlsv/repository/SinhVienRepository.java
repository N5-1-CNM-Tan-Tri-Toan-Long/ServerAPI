package com.n5_qlsv.repository;

import com.n5_qlsv.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

    @Query(value = "SELECT sv.role_name FROM tbl_sinhvien sv where ma_sv = :maSV", nativeQuery = true)
    String findRoleNameByMaSV(Long maSV);

}

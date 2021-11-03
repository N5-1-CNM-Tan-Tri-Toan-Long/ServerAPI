package com.n5_qlsv.repository;

import com.n5_qlsv.entity.SinhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {

    @Query(value = "SELECT sv.role_name FROM tbl_sinhvien sv where ma_sv = :maSV", nativeQuery = true)
    String findRoleNameByMaSV(String maSV);

    @Query("SELECT sv FROM SinhVien sv WHERE sv.maSV LIKE %?1% OR sv.tenSV LIKE %?1%")
    List<SinhVien> search(String keyword, Pageable pageable);

    @Query(value = "Select * From tbl_sinhvien where ma_khoa = :maKhoa",  nativeQuery = true)
    List<SinhVien> findAllByKhoa(Long maKhoa, Pageable pageable);
}

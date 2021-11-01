package com.n5_qlsv.repository;

import com.n5_qlsv.entity.LichHocSinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichHocSVRepository extends JpaRepository<LichHocSinhVien, Long> {
    @Query(value = "FROM LichHocSinhVien L WHERE L.sinhVien.maSV = ?1")
    List<LichHocSinhVien> findByMaSV(String maSV);
}

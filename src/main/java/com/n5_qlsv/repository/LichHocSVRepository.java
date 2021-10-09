package com.n5_qlsv.repository;

import com.n5_qlsv.entity.LichHocSinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichHocSVRepository extends JpaRepository<LichHocSinhVien, Long> {
}

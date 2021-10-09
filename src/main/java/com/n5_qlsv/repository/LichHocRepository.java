package com.n5_qlsv.repository;

import com.n5_qlsv.entity.LichHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichHocRepository extends JpaRepository<LichHoc, Long> {
}

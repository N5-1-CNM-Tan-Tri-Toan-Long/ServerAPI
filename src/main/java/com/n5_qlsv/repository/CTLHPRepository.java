package com.n5_qlsv.repository;

import com.n5_qlsv.entity.ChiTietLopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTLHPRepository extends JpaRepository<ChiTietLopHocPhan, Long> {
}

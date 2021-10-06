package com.n5_qlsv.repository;

import com.n5_qlsv.entity.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, Long> {
}

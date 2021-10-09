package com.n5_qlsv.repository;

import com.n5_qlsv.entity.ChuyenNganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh, Long> {
}

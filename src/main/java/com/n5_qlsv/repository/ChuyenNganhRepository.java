package com.n5_qlsv.repository;

import com.n5_qlsv.entity.ChuyenNganh;
import com.n5_qlsv.entity.SinhVien;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh, Long> {

    @Query(value = "Select * From tbl_chuyennganh where ma_khoa = :maKhoa",  nativeQuery = true)
    List<ChuyenNganh> findAllByKhoa(Long maKhoa, Pageable pageable);

}

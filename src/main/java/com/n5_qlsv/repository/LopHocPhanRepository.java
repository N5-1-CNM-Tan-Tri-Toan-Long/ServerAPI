package com.n5_qlsv.repository;

import com.n5_qlsv.entity.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, Long> {

    @Query(value = "select S from LopHocPhan S WHERE S.hocKy.maHK = ?1")
    List<LopHocPhan> findLHPByMaHK(long maHK);
}

package com.n5_qlsv.repository;

import com.n5_qlsv.entity.ChiTietLopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CTLHPRepository extends JpaRepository<ChiTietLopHocPhan, Long> {

    @Query("FROM ChiTietLopHocPhan C WHERE C.lopHocPhan.maLHP = ?1")
    List<ChiTietLopHocPhan> findByMaLopHocPhan(long id);
}

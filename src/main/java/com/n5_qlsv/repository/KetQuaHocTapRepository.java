package com.n5_qlsv.repository;

import com.n5_qlsv.entity.KetQuaHocTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KetQuaHocTapRepository extends JpaRepository<KetQuaHocTap, Long> {

    @Query("select kq from KetQuaHocTap kq where kq.sinhVien.maSV = ?1")
    List<KetQuaHocTap> findKQHTByMaSV(long maSV);
}

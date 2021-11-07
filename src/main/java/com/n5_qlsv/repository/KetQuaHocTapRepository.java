package com.n5_qlsv.repository;

import com.n5_qlsv.entity.KetQuaHocTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface KetQuaHocTapRepository extends JpaRepository<KetQuaHocTap, Long> {

    @Query("select kq from KetQuaHocTap kq where kq.sinhVien.maSV = ?1")
    List<KetQuaHocTap> findKQHTByMaSV(String maSV);
    @Query(value = "SELECT DISTINCT ma_hk FROM tbl_kqht k join tbl_lophocphan l on k.ma_lhp = l.ma_lhp where ma_sv = ?1", nativeQuery = true)
    Set<Long> findMaHKByMaSV(String maSV);
    @Query(value = "SELECT * FROM tbl_kqht where ma_lhp = ?2 and ma_sv = ?1", nativeQuery = true)
    KetQuaHocTap findKQHTByMaSVAndMaLHP(String maSV, Long maLHP);
}

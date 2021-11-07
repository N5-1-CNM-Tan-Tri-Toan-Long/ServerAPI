package com.n5_qlsv.repository;

import com.n5_qlsv.entity.LichHocSinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LichHocSVRepository extends JpaRepository<LichHocSinhVien, Long> {
    @Query(value = "FROM LichHocSinhVien L WHERE L.sinhVien.maSV = ?1")
    List<LichHocSinhVien> findByMaSV(String maSV);
    @Transactional
    @Query(value = "SELECT * FROM tbl_lichhoc_sinhvien l join tbl_chitietlophocphan c on l.ma_ctlhp = c.ma_ctlhp join tbl_lophocphan lhp on lhp.ma_lhp = c.ma_lhp where ma_sv = ?1 and ma_hk = ?2 ", nativeQuery = true)
    List<LichHocSinhVien> findLHPDaDK(String maSV, Long maHK);
}

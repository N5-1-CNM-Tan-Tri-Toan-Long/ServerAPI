package com.n5_qlsv.repository;

import com.n5_qlsv.entity.HocPhanKhung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocPhanKhungRepository extends JpaRepository<HocPhanKhung, Long> {
    @Query(value = "SELECT * FROM hotrosinhvien.tbl_hocphankhung k " +
            "JOIN hotrosinhvien.tbl_hocphan h ON k.ma_hp = h.ma_hp " +
            "where h.ma_chuyen_nganh = ?1 and k.thu_tu_hoc_ky = ?2", nativeQuery = true)
    List<HocPhanKhung> findAllByChuyenNganhAndHocKi(long maCN, int tthk);

    @Query(value = "SELECT * FROM hotrosinhvien.tbl_hocphankhung k " +
            "JOIN hotrosinhvien.tbl_hocphan h ON k.ma_hp = h.ma_hp " +
            "WHERE h.ma_chuyen_nganh = ?1", nativeQuery = true)
    List<HocPhanKhung> findAllByChuyenNganh(long maCN);
}

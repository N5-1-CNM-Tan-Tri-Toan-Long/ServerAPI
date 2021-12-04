package com.n5_qlsv.repository;

import com.n5_qlsv.entity.HocPhanKhung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocPhanKhungRepository extends JpaRepository<HocPhanKhung, Long> {
    @Query(value = "SELECT mahpk, mh.ten_mon_hoc, hpk.ma_hp, (hp.so_tc_lt + hp.so_tc_th) as so_tc, " +
            "hpk.so_tietlt, hpk.so_tietth, hpk.thu_tu_hoc_ky, hpk.trang_thai  " +
            "FROM hotrosinhvien.tbl_hocphankhung hpk " +
            "join hotrosinhvien.tbl_hocphan hp on hp.ma_hp = hpk.ma_hp " +
            "join hotrosinhvien.tbl_monhoc mh on mh.ma_mh = hp.ma_mh " +
            "where hp.ma_chuyen_nganh = ?1 and hpk.thu_tu_hoc_ky = ?2", nativeQuery = true)
    List<HocPhanKhung> findAllByChuyenNganhAndHocKi(long maCN, int tthk);

    @Query(value = "SELECT * FROM hotrosinhvien.tbl_hocphankhung k " +
            "JOIN hotrosinhvien.tbl_hocphan h ON k.ma_hp = h.ma_hp " +
            "WHERE h.ma_chuyen_nganh = ?1", nativeQuery = true)
    List<HocPhanKhung> findAllByChuyenNganh(long maCN);
}

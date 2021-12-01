package com.n5_qlsv.repository;

import com.n5_qlsv.entity.HocPhan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, String> {

    @Query(value = " SELECT * FROM hotrosinhvien.tbl_hocphan h join tbl_lophocphan l on l.ma_hp = h.ma_hp where ma_hk = ?1", nativeQuery = true)
    List<HocPhan> findHPByMaHK(long maHK);

    @Query(value = "select * from tbl_hocphan where ma_hp not in(select k.ma_hp from tbl_hocphankhung k join tbl_hocphan hp on hp.ma_hp = k.ma_hp)", nativeQuery = true)
    List<HocPhan> findHocPhanNotInHPK();

    @Query(value = "SELECT * FROM hotrosinhvien.tbl_hocphan where ma_chuyen_nganh = :maCN", nativeQuery = true)
    List<HocPhan> findAllByChuyenNganh(long maCN, Pageable pageable);

    @Query("SELECT hp FROM HocPhan hp WHERE hp.maHocPhan LIKE %?1% " +
            "OR hp.monHoc.tenMonHoc LIKE %?1% " +
            "OR hp.chuyenNganh.tenChuyenNganh LIKE %?1% ")
    List<HocPhan> search(String keyword, Pageable pageable);
}

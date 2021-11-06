package com.n5_qlsv.repository;

import com.n5_qlsv.entity.HocPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, String> {

    @Query(value = " SELECT * FROM hotrosinhvien.tbl_hocphan h join tbl_lophocphan l on l.ma_hp = h.ma_hp where ma_hk = ?1", nativeQuery = true)
    List<HocPhan> findHPByMaHK(long maHK);
}

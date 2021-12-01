package com.n5_qlsv.repository;

import com.n5_qlsv.entity.MonHoc;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, Long> {


    @Query(value = "select * from tbl_monhoc where ma_mh not in(select hp.ma_mh from  tbl_hocphan hp join tbl_monhoc mh on mh.ma_mh = hp.ma_mh)", nativeQuery = true)
    List<MonHoc> findMonHocNotInHocPhan();

    @Query(value = "Select * From tbl_monhoc where ma_khoa = :maKhoa",  nativeQuery = true)
    List<MonHoc> findAllByKhoa(Long maKhoa, Pageable pageable);
}

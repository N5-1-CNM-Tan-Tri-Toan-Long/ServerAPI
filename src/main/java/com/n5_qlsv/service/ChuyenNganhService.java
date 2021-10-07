package com.n5_qlsv.service;

import com.n5_qlsv.entity.ChuyenNganh;
import com.n5_qlsv.entity.HocKy;

import java.util.List;

public interface ChuyenNganhService {
    ChuyenNganh saveChuyenNganh(ChuyenNganh chuyenNganh);
    ChuyenNganh findChuyenNganhById(Long maChuyenNganh);
    List<ChuyenNganh> findAllChuyenNganh();
    void deleteChuyenNganhById(Long maChuyenNganh);
    ChuyenNganh updateChuyenNganhById(Long maChuyenNganh, ChuyenNganh chuyenNganh);
}

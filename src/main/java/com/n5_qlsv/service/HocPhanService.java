package com.n5_qlsv.service;

import com.n5_qlsv.entity.HocPhan;

import java.awt.print.Pageable;
import java.util.List;

public interface HocPhanService {
    HocPhan saveHocPhan(HocPhan hocPhan);
    HocPhan findHocPhanById(Long maHP);
    List<HocPhan> findAllHocPhan(int page, int size);
    void deleteHocPhanById(Long maHP);
    HocPhan updateHocPhanById(Long maHP, HocPhan hocPhan);
}

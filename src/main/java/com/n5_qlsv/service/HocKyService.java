package com.n5_qlsv.service;

import com.n5_qlsv.entity.HocKy;

import java.util.List;

public interface HocKyService {
    HocKy saveHocKy(HocKy hocKy);
    HocKy findHocKyById(Long maHK);
    List<HocKy> findAllHocKy(int page, int size);
    void deleteHocKyById(Long maHK);
    HocKy updateHocKyById(Long maHK, HocKy hocKy);
}
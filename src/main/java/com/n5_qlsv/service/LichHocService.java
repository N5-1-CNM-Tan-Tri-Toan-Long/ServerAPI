package com.n5_qlsv.service;


import com.n5_qlsv.entity.LichHoc;

import java.util.List;

public interface LichHocService {
    LichHoc saveLichHoc(LichHoc lichHoc);
    LichHoc findLichHocById(Long maLH);
    List<LichHoc> findAllLichHoc(int page, int size);
    void deleteLichHocById(Long maLH);
    LichHoc updateLichHocById(Long maLH, LichHoc lichHoc);
}

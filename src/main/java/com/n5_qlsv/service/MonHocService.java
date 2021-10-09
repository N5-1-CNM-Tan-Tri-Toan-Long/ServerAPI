package com.n5_qlsv.service;

import com.n5_qlsv.entity.MonHoc;

import java.util.List;

public interface MonHocService {
    MonHoc saveMonHoc(MonHoc monHoc);
    MonHoc findMonHocById(Long maMonHoc);
    List<MonHoc> findAllMonHoc();
    void deleteMonHocById(Long maMonHoc);
    MonHoc updateMonHocById(Long maMonHoc, MonHoc monHoc);
}

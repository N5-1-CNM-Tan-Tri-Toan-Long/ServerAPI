package com.n5_qlsv.service;



import com.n5_qlsv.entity.LichHocSinhVien;

import java.util.List;

public interface LichHocSVService {

    LichHocSinhVien saveLichHocSinhVien(LichHocSinhVien lichHocSinhVien);
    LichHocSinhVien findLichHocSinhVienById(Long maLHSV);
    List<LichHocSinhVien> findAllLichHocSinhVien(int page, int size);
    void deleteLichHocSinhVienById(Long maLHSV);
    LichHocSinhVien updateLichHocSinhVienById(Long maLHSV, LichHocSinhVien lichHocSinhVien);
}

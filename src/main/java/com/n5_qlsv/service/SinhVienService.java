package com.n5_qlsv.service;

import com.n5_qlsv.entity.SinhVien;

import java.util.List;

public interface SinhVienService {
    SinhVien saveSinhVien(SinhVien sinhVien);
    SinhVien findSinhVienById(Long maSinhVien);
    SinhVien updateSinhVienById(Long maSinhVien, SinhVien sinhVien);
    void deleteSinhVienById(Long maSinhVien);
    List<SinhVien> findAllSinhVien();
}

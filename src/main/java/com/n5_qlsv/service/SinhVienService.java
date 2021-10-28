package com.n5_qlsv.service;

import com.n5_qlsv.entity.SinhVien;

import java.util.List;

public interface SinhVienService {
    SinhVien saveSinhVien(SinhVien sinhVien);
    SinhVien findSinhVienById(String maSinhVien);
    SinhVien updateSinhVienById(String maSinhVien, SinhVien sinhVien);
    void deleteSinhVienById(String maSinhVien);
    List<SinhVien> findAllSinhVien(int page, int size);
    String findRoleNameByMaSV(String maSV);
}

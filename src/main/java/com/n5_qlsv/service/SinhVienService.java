package com.n5_qlsv.service;

import com.n5_qlsv.entity.SinhVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SinhVienService {
    SinhVien saveSinhVien(SinhVien sinhVien);
    SinhVien findSinhVienById(String maSinhVien);
    SinhVien updateSinhVienById(String maSinhVien, SinhVien sinhVien);
    void deleteSinhVienById(String maSinhVien);
    List<SinhVien> findAllSinhVien(int page, int size);
    String findRoleNameByMaSV(String maSV);
    List<SinhVien> search(String keyword, int page, int size);
    List<SinhVien> findAllSinhViensByKhoa(Long maKhoa, int page, int size);
}

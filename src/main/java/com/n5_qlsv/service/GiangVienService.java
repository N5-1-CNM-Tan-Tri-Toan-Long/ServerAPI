package com.n5_qlsv.service;

import com.n5_qlsv.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
    GiangVien saveGiangVien(GiangVien giangVien);
    GiangVien findGiangVienById(Long maGV);
    List<GiangVien> findAllGiangVien();
    void deleteGiangVienById(Long maGV);
    GiangVien updateGiangVienById(Long maGV, GiangVien giangVien);
}

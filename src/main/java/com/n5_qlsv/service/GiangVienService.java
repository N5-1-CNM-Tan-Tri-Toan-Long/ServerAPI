package com.n5_qlsv.service;

import com.n5_qlsv.entity.GiangVien;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GiangVienService {
    GiangVien saveGiangVien(GiangVien giangVien);
    GiangVien findGiangVienById(Long maGV);
    List<GiangVien> findAllGiangVien(int page, int size);
    void deleteGiangVienById(Long maGV);
    GiangVien updateGiangVienById(Long maGV, GiangVien giangVien);
    void saveGiangVienByFile(MultipartFile file);
}

package com.n5_qlsv.service;

import com.n5_qlsv.entity.Khoa;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface KhoaService {
    Khoa saveKhoa(Khoa khoa);
    Khoa findKhoaById(Long maKhoa);
    List<Khoa> findAllKhoa(int page, int size);
    void deleteKhoaById(Long maKhoa);
    Khoa updateKhoaById(Long maKhoa, Khoa khoa);
    void saveKhoaByFile(MultipartFile file);
}

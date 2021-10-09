package com.n5_qlsv.service;

import com.n5_qlsv.entity.Khoa;

import java.util.List;

public interface KhoaService {
    Khoa saveKhoa(Khoa khoa);
    Khoa findKhoaById(Long maKhoa);
    List<Khoa> findAllKhoa();
    void deleteKhoaById(Long maKhoa);
    Khoa updateKhoaById(Long maKhoa, Khoa khoa);
}

package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.SinhVien;
import com.n5_qlsv.repository.SinhVienRepository;
import com.n5_qlsv.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Override
    public SinhVien saveSinhVien(SinhVien sinhVien) {
        sinhVien.setMaSV(0);
        return sinhVienRepository.save(sinhVien);
    }

    @Override
    public SinhVien findSinhVienById(Long maSinhVien) {
        return sinhVienRepository.findById(maSinhVien).get();
    }

    @Override
    public SinhVien updateSinhVienById(Long maSinhVien, SinhVien sinhVien) {
        sinhVien.setMaSV(maSinhVien);
        return sinhVienRepository.save(sinhVien);
    }

    @Override
    public void deleteSinhVienById(Long maSinhVien) {
        sinhVienRepository.deleteById(maSinhVien);
    }

    @Override
    public List<SinhVien> findAllSinhVien() {
        return sinhVienRepository.findAll();
    }
}

package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.SinhVien;
import com.n5_qlsv.repository.SinhVienRepository;
import com.n5_qlsv.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Override
    public SinhVien saveSinhVien(SinhVien sinhVien) {
        sinhVien.setMaSV("");
        return sinhVienRepository.save(sinhVien);
    }

    @Override
    public SinhVien findSinhVienById(String maSinhVien) {
        return sinhVienRepository.findById(maSinhVien).get();
    }

    @Override
    public SinhVien updateSinhVienById(String maSinhVien, SinhVien sinhVien) {
        sinhVien.setMaSV(maSinhVien);
        return sinhVienRepository.save(sinhVien);
    }

    @Override
    public void deleteSinhVienById(String maSinhVien) {
        sinhVienRepository.deleteById(maSinhVien);
    }

    @Override
    public List<SinhVien> findAllSinhVien(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return sinhVienRepository.findAll(pageable).getContent();
    }

    @Override
    public String findRoleNameByMaSV(String maSV) {
        return sinhVienRepository.findRoleNameByMaSV(maSV);
    }

    @Override
    public List<SinhVien> search(String keyword) {
        return sinhVienRepository.search(keyword);
    }

    @Override
    public List<SinhVien> findAllSinhViensByKhoa(Long maKhoa, int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return sinhVienRepository.findAllByKhoa(maKhoa, pageable);
    }
}

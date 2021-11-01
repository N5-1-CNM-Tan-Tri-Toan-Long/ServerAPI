package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.LichHocSinhVien;
import com.n5_qlsv.repository.LichHocSVRepository;
import com.n5_qlsv.service.LichHocSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichHocSVServiceImpl implements LichHocSVService {

    @Autowired
    private LichHocSVRepository lichHocSVRepository;


    @Override
    public LichHocSinhVien saveLichHocSinhVien(LichHocSinhVien lichHocSinhVien) {
        lichHocSinhVien.setMaLHSV(0);
        return lichHocSVRepository.save(lichHocSinhVien);
    }

    @Override
    public LichHocSinhVien findLichHocSinhVienById(Long maLHSV) {
        return lichHocSVRepository.findById(maLHSV).get();
    }

    @Override
    public List<LichHocSinhVien> findAllLichHocSinhVien(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page,size);
        return lichHocSVRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteLichHocSinhVienById(Long maLHSV) {
        lichHocSVRepository.deleteById(maLHSV);
    }

    @Override
    public LichHocSinhVien updateLichHocSinhVienById(Long maLHSV, LichHocSinhVien lichHocSinhVien) {
        lichHocSinhVien.setMaLHSV(maLHSV);
        return lichHocSVRepository.save(lichHocSinhVien);
    }

    @Override
    public List<LichHocSinhVien> findByMaSV(String maSV) {
        return lichHocSVRepository.findByMaSV(maSV);
    }
}

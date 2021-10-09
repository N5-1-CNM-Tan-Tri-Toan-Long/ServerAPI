package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.GiangVien;
import com.n5_qlsv.repository.GiangVienRepository;
import com.n5_qlsv.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiangVienServiceImpl implements GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Override
    public GiangVien saveGiangVien(GiangVien giangVien) {
        giangVien.setMaGV(0);
        return giangVienRepository.save(giangVien);
    }

    @Override
    public GiangVien findGiangVienById(Long maGV) {
        return giangVienRepository.findById(maGV).get();
    }

    @Override
    public List<GiangVien> findAllGiangVien(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return giangVienRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteGiangVienById(Long maGV) {
        giangVienRepository.deleteById(maGV);
    }

    @Override
    public GiangVien updateGiangVienById(Long maGV, GiangVien giangVien) {
        giangVien.setMaGV(maGV);
        return giangVienRepository.save(giangVien);
    }
}

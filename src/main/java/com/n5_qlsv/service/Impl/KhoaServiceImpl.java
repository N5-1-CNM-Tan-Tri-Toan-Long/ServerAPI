package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.Khoa;
import com.n5_qlsv.repository.KhoaRepository;
import com.n5_qlsv.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaServiceImpl implements KhoaService {

    @Autowired
    private KhoaRepository khoaRepository;

    @Override
    public Khoa saveKhoa(Khoa khoa) {
        khoa.setMaKhoa(0);
        return khoaRepository.save(khoa);
    }

    @Override
    public Khoa findKhoaById(Long maKhoa) {
        return khoaRepository.findById(maKhoa).get();
    }

    @Override
    public List<Khoa> findAllKhoa(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return khoaRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteKhoaById(Long maKhoa) {
        khoaRepository.deleteById(maKhoa);
    }

    @Override
    public Khoa updateKhoaById(Long maKhoa, Khoa khoa) {
        khoa.setMaKhoa(maKhoa);
        return khoaRepository.save(khoa);
    }
}

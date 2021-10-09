package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.LichHoc;
import com.n5_qlsv.repository.LichHocRepository;
import com.n5_qlsv.service.LichHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichHocServiceImpl implements LichHocService {

    @Autowired
    private LichHocRepository lichHocRepository;


    @Override
    public LichHoc saveLichHoc(LichHoc lichHoc) {
        lichHoc.setMaLichHoc(0);
        return lichHocRepository.save(lichHoc);
    }

    @Override
    public LichHoc findLichHocById(Long maLH) {
        return lichHocRepository.findById(maLH).get();
    }

    @Override
    public List<LichHoc> findAllLichHoc(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page,size);
        return lichHocRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteLichHocById(Long maLH) {
        lichHocRepository.deleteById(maLH);
    }

    @Override
    public LichHoc updateLichHocById(Long maLH, LichHoc lichHoc) {
       lichHoc.setMaLichHoc(maLH);
        return lichHocRepository.save(lichHoc);
    }
}

package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.MonHoc;
import com.n5_qlsv.repository.MonHocRepository;
import com.n5_qlsv.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonHocServiceImpl implements MonHocService {

    @Autowired
    private MonHocRepository monHocRepository;

    @Override
    public MonHoc saveMonHoc(MonHoc monHoc) {
        monHoc.setMaMonHoc(0);
        return monHocRepository.save(monHoc);
    }

    @Override
    public MonHoc findMonHocById(Long maMonHoc) {
        return monHocRepository.findById(maMonHoc).get();
    }

    @Override
    public List<MonHoc> findAllMonHoc(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return monHocRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteMonHocById(Long maMonHoc) {
        monHocRepository.deleteById(maMonHoc);
    }

    @Override
    public MonHoc updateMonHocById(Long maMonHoc, MonHoc monHoc) {
        monHoc.setMaMonHoc(maMonHoc);
        return monHocRepository.save(monHoc);
    }
}

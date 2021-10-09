package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.ChuyenNganh;
import com.n5_qlsv.repository.ChuyenNganhRepository;
import com.n5_qlsv.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenNganhServiceImpl implements ChuyenNganhService {

    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;

    @Override
    public ChuyenNganh saveChuyenNganh(ChuyenNganh chuyenNganh) {
        chuyenNganh.setMaChuyenNganh(0);
        return chuyenNganhRepository.save(chuyenNganh);
    }

    @Override
    public ChuyenNganh findChuyenNganhById(Long maChuyenNganh) {
        return chuyenNganhRepository.findById(maChuyenNganh).get();
    }

    @Override
    public List<ChuyenNganh> findAllChuyenNganh(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return chuyenNganhRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteChuyenNganhById(Long maChuyenNganh) {
        chuyenNganhRepository.deleteById(maChuyenNganh);
    }

    @Override
    public ChuyenNganh updateChuyenNganhById(Long maChuyenNganh, ChuyenNganh chuyenNganh) {
        chuyenNganh.setMaChuyenNganh(maChuyenNganh);
        return chuyenNganhRepository.save(chuyenNganh);
    }
}

package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.HocKy;
import com.n5_qlsv.repository.HocKyRepository;
import com.n5_qlsv.service.HocKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocKyServiceImpl implements HocKyService {

    @Autowired
    private HocKyRepository hocKyRepository;

    @Override
    public HocKy saveHocKy(HocKy hocKy) {
        hocKy.setMaHK(0);
        return hocKyRepository.save(hocKy);
    }

    @Override
    public HocKy findHocKyById(Long maHK) {
        return hocKyRepository.findById(maHK).get();
    }

    @Override
    public List<HocKy> findAllHocKy() {
        return hocKyRepository.findAll();
    }

    @Override
    public void deleteHocKyById(Long maHK) {
        hocKyRepository.deleteById(maHK);
    }

    @Override
    public HocKy updateHocKyById(Long maHK, HocKy hocKy) {
        hocKy.setMaHK(maHK);
        return hocKyRepository.save(hocKy);
    }
}
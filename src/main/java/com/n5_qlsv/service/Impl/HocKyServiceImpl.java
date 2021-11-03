package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.HocKy;
import com.n5_qlsv.helper.ExcelHelper;
import com.n5_qlsv.repository.HocKyRepository;
import com.n5_qlsv.service.HocKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<HocKy> findAllHocKy(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return hocKyRepository.findAll(pageable).getContent();
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

    @Override
    public void saveHocKyByFile(MultipartFile file) {
        try {
            List<HocKy> hocKyList = ExcelHelper.excelToTutorials(file.getInputStream());
            hocKyRepository.saveAll(hocKyList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}

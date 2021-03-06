package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.HocPhan;
import com.n5_qlsv.entity.LopHoc;
import com.n5_qlsv.helper.ExcelHelperHocPhan;
import com.n5_qlsv.helper.ExcelHelperLopHoc;
import com.n5_qlsv.repository.LopHocRepository;
import com.n5_qlsv.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class LopHocServiceImpl implements LopHocService {

    @Autowired
    private LopHocRepository lopHocRepository;

    @Override
    public LopHoc saveLopHoc(LopHoc lopHoc) {
        lopHoc.setMaLop(0);
        return lopHocRepository.save(lopHoc);
    }

    @Override
    public LopHoc findLopHocById(Long maLopHoc) {
        return lopHocRepository.findById(maLopHoc).get();
    }

    @Override
    public List<LopHoc> findAllLopHoc(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return lopHocRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteLopHocById(Long maLopHoc) {
        lopHocRepository.deleteById(maLopHoc);
    }

    @Override
    public LopHoc updateLopHocById(Long maLopHoc, LopHoc lopHoc) {
        lopHoc.setMaLop(maLopHoc);
        return lopHocRepository.save(lopHoc);
    }

    @Override
    public void saveLopHocByFile(MultipartFile file) {
        try {
            List<LopHoc> lopHocList = ExcelHelperLopHoc.excelToTutorials(file.getInputStream());
            lopHocRepository.saveAll(lopHocList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

}

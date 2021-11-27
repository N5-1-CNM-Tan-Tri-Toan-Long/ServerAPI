package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.HocPhan;
import com.n5_qlsv.entity.LopHoc;
import com.n5_qlsv.entity.MonHoc;
import com.n5_qlsv.helper.ExcelHelperHocPhan;
import com.n5_qlsv.helper.ExcelHelperLopHoc;
import com.n5_qlsv.helper.ExcelHelperMonHoc;
import com.n5_qlsv.repository.MonHocRepository;
import com.n5_qlsv.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @Override
    public List<MonHoc> findMonHocNotInHocPhan() {
        return monHocRepository.findMonHocNotInHocPhan();
    }

    @Override
    public void saveMonHocByFile(MultipartFile file) {
        try {
            List<MonHoc> monHocList = ExcelHelperMonHoc.excelToTutorials(file.getInputStream());
            monHocRepository.saveAll(monHocList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Override
    public List<MonHoc> findAllByKhoa(Long maKhoa, int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return monHocRepository.findAllByKhoa(maKhoa, pageable);
    }
}

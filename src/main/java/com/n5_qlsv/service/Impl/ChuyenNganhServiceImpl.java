package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.ChuyenNganh;
import com.n5_qlsv.entity.SinhVien;
import com.n5_qlsv.helper.ExcelHelperChuyenNganh;
import com.n5_qlsv.helper.ExcelHelperSinhVien;
import com.n5_qlsv.repository.ChuyenNganhRepository;
import com.n5_qlsv.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @Override
    public List<ChuyenNganh> findAllByKhoa(Long maKhoa, int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return chuyenNganhRepository.findAllByKhoa(maKhoa, pageable);
    }

    @Override
    public void saveChuyenNganhByFile(MultipartFile file) {
        try {
            List<ChuyenNganh> sinhVienList = ExcelHelperChuyenNganh.excelToTutorials(file.getInputStream());
            chuyenNganhRepository.saveAll(sinhVienList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}

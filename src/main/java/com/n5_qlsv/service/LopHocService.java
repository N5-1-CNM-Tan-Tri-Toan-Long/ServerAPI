package com.n5_qlsv.service;

import com.n5_qlsv.entity.LopHoc;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LopHocService {
    LopHoc saveLopHoc(LopHoc lopHoc);
    LopHoc findLopHocById(Long maLopHoc);
    List<LopHoc> findAllLopHoc(int page, int size);
    void deleteLopHocById(Long maLopHoc);
    LopHoc updateLopHocById(Long maLopHoc, LopHoc lopHoc);
    void saveLopHocByFile(MultipartFile file);

}

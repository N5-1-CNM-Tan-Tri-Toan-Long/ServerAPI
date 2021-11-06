package com.n5_qlsv.service;

import com.n5_qlsv.entity.MonHoc;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MonHocService {
    MonHoc saveMonHoc(MonHoc monHoc);
    MonHoc findMonHocById(Long maMonHoc);
    List<MonHoc> findAllMonHoc(int page, int size);
    void deleteMonHocById(Long maMonHoc);
    MonHoc updateMonHocById(Long maMonHoc, MonHoc monHoc);
    List<MonHoc> findMonHocNotInHocPhan();
    void saveMonHocByFile(MultipartFile file);
}

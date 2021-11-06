package com.n5_qlsv.service;

import com.n5_qlsv.entity.HocPhan;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HocPhanService {
    HocPhan saveHocPhan(HocPhan hocPhan);
    HocPhan findHocPhanById(String maHP);
    List<HocPhan> findAllHocPhan(int page, int size);
    void deleteHocPhanById(String maHP);
    HocPhan updateHocPhanById(String maHP, HocPhan hocPhan);
    List<HocPhan> findHPByMaHK(long maHK);
    void saveHocPhanByFile(MultipartFile file);
}

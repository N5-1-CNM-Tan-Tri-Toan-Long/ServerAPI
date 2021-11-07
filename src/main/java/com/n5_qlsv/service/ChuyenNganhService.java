package com.n5_qlsv.service;

import com.n5_qlsv.entity.ChuyenNganh;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChuyenNganhService {
    ChuyenNganh saveChuyenNganh(ChuyenNganh chuyenNganh);
    ChuyenNganh findChuyenNganhById(Long maChuyenNganh);
    List<ChuyenNganh> findAllChuyenNganh(int page, int size);
    void deleteChuyenNganhById(Long maChuyenNganh);
    ChuyenNganh updateChuyenNganhById(Long maChuyenNganh, ChuyenNganh chuyenNganh);
    List<ChuyenNganh> findAllByKhoa(Long maKhoa, int page, int size);
    void saveChuyenNganhByFile(MultipartFile file);
}

package com.n5_qlsv.service;

import com.n5_qlsv.entity.HocPhan;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HocPhanService {

    HocPhan saveHocPhan(HocPhan hocPhan);

    HocPhan findHocPhanById(String maHP);

    HocPhan updateHocPhanById(String maHP, HocPhan hocPhan);

    void deleteHocPhanById(String maHP);

    void saveHocPhanByFile(MultipartFile file);

    List<HocPhan> findAllHocPhan(int page, int size);

    List<HocPhan> findHPByMaHK(long maHK);

    List<HocPhan> findMonHocNotInHocPhan();

    List<HocPhan> search(String keyword, int page, int size);

    List<HocPhan> findAllByChuyenNganh(Long maCN, int page, int size);
}

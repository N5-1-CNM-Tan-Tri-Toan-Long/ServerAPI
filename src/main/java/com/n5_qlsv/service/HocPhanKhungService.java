package com.n5_qlsv.service;

import com.n5_qlsv.entity.HocPhanKhung;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HocPhanKhungService {

    HocPhanKhung saveHPK(HocPhanKhung hpk);

    HocPhanKhung findHPKById(Long maHPK);

    List<HocPhanKhung> findAllHPK(int page, int size);

    void deleteHPKById(Long maHPK);

    HocPhanKhung updateHPKById(Long maHPK, HocPhanKhung hpk);

    void saveHPKByFile(MultipartFile file);

    List<HocPhanKhung> findAllByChuyenNganhAndHocKi(long maCN, int tthk);

    List<HocPhanKhung> findAllByChuyenNganh(long maCN);
}

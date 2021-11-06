package com.n5_qlsv.service;



import com.n5_qlsv.entity.LopHocPhan;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LopHocPhanService {
    LopHocPhan saveLopHocPhan(LopHocPhan lopHocPhan);
    LopHocPhan findLopHocPhanById(Long maLHP);
    List<LopHocPhan> findAllLopHocPhan(int page, int size);
    List<LopHocPhan> findByMaHocPhan(String maHocPhan);
    void deleteLopHocPhanById(Long maLHP);
    LopHocPhan updateLopHocPhanById(Long maLHP, LopHocPhan lopHocPhan);
    List<LopHocPhan> findLHPByMaHK(long maHK);
    void saveLopHocPhanByFile(MultipartFile file);
}

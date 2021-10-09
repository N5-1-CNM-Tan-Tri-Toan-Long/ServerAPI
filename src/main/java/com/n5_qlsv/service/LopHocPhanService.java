package com.n5_qlsv.service;



import com.n5_qlsv.entity.LopHocPhan;

import java.util.List;

public interface LopHocPhanService {
    LopHocPhan saveLopHocPhan(LopHocPhan lopHocPhan);
    LopHocPhan findLopHocPhanById(Long maLHP);
    List<LopHocPhan> findAllLopHocPhan(int page, int size);
    void deleteLopHocPhanById(Long maLHP);
    LopHocPhan updateLopHocPhanById(Long maLHP, LopHocPhan lopHocPhan);
}

package com.n5_qlsv.service;


import com.n5_qlsv.entity.ChiTietLopHocPhan;

import java.util.List;

public interface CTLHPService {
    ChiTietLopHocPhan saveChiTietLHP(ChiTietLopHocPhan chiTietLopHocPhan);

    ChiTietLopHocPhan findChiTietLHPById(Long maCTLHP);

    List<ChiTietLopHocPhan> findAllChiTietLHP(int page, int size);

    void deleteChiTietLHPById(Long maCTLHP);

    ChiTietLopHocPhan updateChiTietLHPById(Long maCTLHP, ChiTietLopHocPhan chiTietLopHocPhan);

    List<ChiTietLopHocPhan> findByMaLHP(long id);
}

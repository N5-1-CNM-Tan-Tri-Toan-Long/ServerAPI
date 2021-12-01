package com.n5_qlsv.service;



import com.n5_qlsv.entity.KetQuaHocTap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface KetQuaHTService {
    KetQuaHocTap saveKQHT(KetQuaHocTap ketQuaHocTap);
    KetQuaHocTap findKQHTById(Long maKQHT);
    List<KetQuaHocTap> findAllKQHT(int page, int size);
    void deleteKQHTById(Long maKQHT);
    KetQuaHocTap updateKQHTById(Long maKQHT, KetQuaHocTap ketQuaHocTap);
    List<KetQuaHocTap> findKQHTByMaSV(String maSV);
    List<KetQuaHocTap> findKQHTByMaSVWithPageSize(String maSV, int page, int size);
    Set<Long> findMaHKByMaSV(String maSV);
    KetQuaHocTap findKQHTByMaSVAndMaLHP(String maSV, Long maLHP);
    void saveKetQuaHocTapByFile(MultipartFile file);
    List<KetQuaHocTap> findKQHYByMaLHP(Long maLHP);
}

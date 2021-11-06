package com.n5_qlsv.service;



import com.n5_qlsv.entity.KetQuaHocTap;

import java.util.List;
import java.util.Set;

public interface KetQuaHTService {
    KetQuaHocTap saveKQHT(KetQuaHocTap ketQuaHocTap);
    KetQuaHocTap findKQHTById(Long maKQHT);
    List<KetQuaHocTap> findAllKQHT(int page, int size);
    void deleteKQHTById(Long maKQHT);
    KetQuaHocTap updateKQHTById(Long maKQHT, KetQuaHocTap ketQuaHocTap);
    List<KetQuaHocTap> findKQHTByMaSV(String maSV);
    Set<Long> findMaHKByMaSV(String maSV);
}

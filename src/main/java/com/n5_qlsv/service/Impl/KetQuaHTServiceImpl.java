package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.KetQuaHocTap;
import com.n5_qlsv.repository.KetQuaHocTapRepository;
import com.n5_qlsv.service.KetQuaHTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class KetQuaHTServiceImpl implements KetQuaHTService {

    @Autowired
    private KetQuaHocTapRepository ketQuaHocTapRepository;

    @Override
    public KetQuaHocTap saveKQHT(KetQuaHocTap ketQuaHocTap) {
        ketQuaHocTap.setMaKQHT(0);
        return ketQuaHocTapRepository.save(ketQuaHocTap);
    }

    @Override
    public KetQuaHocTap findKQHTById(Long maKQHT) {
        return ketQuaHocTapRepository.findById(maKQHT).get();
    }

    @Override
    public List<KetQuaHocTap> findAllKQHT(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page,size);
        return ketQuaHocTapRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteKQHTById(Long maKQHT) {
        ketQuaHocTapRepository.deleteById(maKQHT);
    }

    @Override
    public KetQuaHocTap updateKQHTById(Long maKQHT, KetQuaHocTap ketQuaHocTap) {
        ketQuaHocTap.setMaKQHT(maKQHT);
        return ketQuaHocTapRepository.save(ketQuaHocTap);
    }

    @Override
    public List<KetQuaHocTap> findKQHTByMaSV(String maSV) {
        return ketQuaHocTapRepository.findKQHTByMaSV(maSV);
    }

    @Override
    public Set<Long> findMaHKByMaSV(String maSV) {
        return ketQuaHocTapRepository.findMaHKByMaSV(maSV);
    }

    @Override
    public KetQuaHocTap findKQHTByMaSVAndMaLHP(String maSV, Long maLHP) {
        return ketQuaHocTapRepository.findKQHTByMaSVAndMaLHP(maSV, maLHP);
    }
}

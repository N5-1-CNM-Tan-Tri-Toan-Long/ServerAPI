package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.ChiTietLopHocPhan;
import com.n5_qlsv.repository.CTLHPRepository;
import com.n5_qlsv.service.CTLHPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTLHPServiceImpl implements CTLHPService {

    @Autowired
    private CTLHPRepository ctlhpRepository;

    @Override
    public ChiTietLopHocPhan saveChiTietLHP(ChiTietLopHocPhan chiTietLopHocPhan) {
        chiTietLopHocPhan.setMaCTLHP(0);
        return ctlhpRepository.save(chiTietLopHocPhan);
    }

    @Override
    public ChiTietLopHocPhan findChiTietLHPById(Long maCTLHP) {
        return ctlhpRepository.findById(maCTLHP).get();
    }

    @Override
    public List<ChiTietLopHocPhan> findAllChiTietLHP(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page,size);
        return ctlhpRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteChiTietLHPById(Long maCTLHP) {
        ctlhpRepository.deleteById(maCTLHP);
    }

    @Override
    public ChiTietLopHocPhan updateChiTietLHPById(Long maCTLHP, ChiTietLopHocPhan chiTietLopHocPhan) {
        chiTietLopHocPhan.setMaCTLHP(maCTLHP);
        return ctlhpRepository.save(chiTietLopHocPhan);
    }
}

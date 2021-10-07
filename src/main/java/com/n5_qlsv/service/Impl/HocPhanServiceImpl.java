package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.HocPhan;
import com.n5_qlsv.repository.HocPhanRepository;
import com.n5_qlsv.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocPhanServiceImpl implements HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Override
    public HocPhan saveHocPhan(HocPhan hocPhan) {
        hocPhan.setMaHocPhan(0);
        return hocPhanRepository.save(hocPhan);
    }

    @Override
    public HocPhan findHocPhanById(Long maHP) {
        return hocPhanRepository.findById(maHP).get();
    }

    @Override
    public List<HocPhan> findAllHocPhan(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page,size);

        return hocPhanRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteHocPhanById(Long maHP) {
        hocPhanRepository.deleteById(maHP);
    }

    @Override
    public HocPhan updateHocPhanById(Long maHP, HocPhan hocPhan) {
        hocPhan.setMaHocPhan(maHP);
        return hocPhanRepository.save(hocPhan);
    }
}

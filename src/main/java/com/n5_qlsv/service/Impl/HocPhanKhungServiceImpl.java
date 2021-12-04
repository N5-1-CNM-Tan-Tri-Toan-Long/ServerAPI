package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.HocPhanKhung;
import com.n5_qlsv.helper.ExcelHelperHocPhanKhung;
import com.n5_qlsv.repository.HocPhanKhungRepository;
import com.n5_qlsv.service.HocPhanKhungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class HocPhanKhungServiceImpl implements HocPhanKhungService {

    @Autowired
    private HocPhanKhungRepository repository;

    @Override
    public HocPhanKhung saveHPK(HocPhanKhung hpk) {
        hpk.setMaHPK(0);
        return repository.save(hpk);
    }

    @Override
    public HocPhanKhung findHPKById(Long maHPK) {
        return repository.findById(maHPK).get();
    }

    @Override
    public List<HocPhanKhung> findAllHPK(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return repository.findAll(pageable).getContent();
    }

    @Override
    public void deleteHPKById(Long maHPK) {
        repository.deleteById(maHPK);
    }

    @Override
    public HocPhanKhung updateHPKById(Long maHPK, HocPhanKhung hpk) {
        hpk.setMaHPK(maHPK);
        return repository.save(hpk);
    }

    @Override
    public void saveHPKByFile(MultipartFile file) {

        try {
            List<HocPhanKhung> hocPhanKhungList = ExcelHelperHocPhanKhung.excelToTutorials(file.getInputStream());
            repository.saveAll(hocPhanKhungList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }

    }

    @Override
    public List<HocPhanKhung> findAllByChuyenNganhAndHocKi(long maCN, int tthk) {
        return repository.findAllByChuyenNganhAndHocKi(maCN, tthk);
    }

    @Override
    public List<HocPhanKhung> findAllByChuyenNganh(long maCN) {
        return repository.findAllByChuyenNganh(maCN);
    }
}

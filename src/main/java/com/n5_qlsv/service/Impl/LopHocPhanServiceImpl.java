package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.HocPhan;
import com.n5_qlsv.entity.LopHocPhan;
import com.n5_qlsv.helper.ExcelHelperHocPhan;
import com.n5_qlsv.helper.ExcelHelperLopHocPhan;
import com.n5_qlsv.repository.LopHocPhanRepository;
import com.n5_qlsv.service.LopHocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class LopHocPhanServiceImpl implements LopHocPhanService {

    @Autowired
    private LopHocPhanRepository lopHocPhanRepository;
    @Override
    public LopHocPhan saveLopHocPhan(LopHocPhan lopHocPhan) {
       lopHocPhan.setMaLHP(0);
        return lopHocPhanRepository.save(lopHocPhan);
    }

    @Override
    public LopHocPhan findLopHocPhanById(Long maLHP) {
        return lopHocPhanRepository.findById(maLHP).get();
    }

    @Override
    public List<LopHocPhan> findAllLopHocPhan(int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);
        return lopHocPhanRepository.findAll(pageable).getContent();
    }

    @Override
    public List<LopHocPhan> findByMaHocPhan(String maHocPhan) {
        return lopHocPhanRepository.findLHPByMaHocPhan(maHocPhan);
    }

    @Override
    public void deleteLopHocPhanById(Long maLHP) {
        lopHocPhanRepository.deleteById(maLHP);
    }

    @Override
    public LopHocPhan updateLopHocPhanById(Long maLHP, LopHocPhan lopHocPhan) {
        lopHocPhan.setMaLHP(maLHP);
        return lopHocPhanRepository.save(lopHocPhan);
    }

    @Override
    public List<LopHocPhan> findLHPByMaHK(long maHK) {
        return lopHocPhanRepository.findLHPByMaHK(maHK);
    }

    @Override
    public void saveLopHocPhanByFile(MultipartFile file) {
        try {
            List<LopHocPhan> lophocPhanList = ExcelHelperLopHocPhan.excelToTutorials(file.getInputStream());
            lopHocPhanRepository.saveAll(lophocPhanList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}

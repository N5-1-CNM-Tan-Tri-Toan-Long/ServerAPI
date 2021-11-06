package com.n5_qlsv.service.Impl;


import com.n5_qlsv.entity.HocPhan;
import com.n5_qlsv.entity.MonHoc;
import com.n5_qlsv.helper.ExcelHelperHocPhan;
import com.n5_qlsv.repository.HocPhanRepository;
import com.n5_qlsv.repository.MonHocRepository;
import com.n5_qlsv.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class HocPhanServiceImpl implements HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Autowired
    private MonHocRepository monHocRepository;

    @Override
    public HocPhan saveHocPhan(HocPhan hocPhan) {
        hocPhan.setMaHocPhan("");
        return hocPhanRepository.save(hocPhan);
    }

    @Override
    public HocPhan findHocPhanById(String maHP) {
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
    public void deleteHocPhanById(String maHP) {
        HocPhan hocPhan = hocPhanRepository.findById(maHP).get();
        MonHoc monHoc = monHocRepository.findById(hocPhan.getMonHoc().getMaMonHoc()).get();
        monHoc.setHocPhan(null);
        monHocRepository.save(monHoc);
        hocPhanRepository.deleteById(maHP);
    }

    @Override
    public HocPhan updateHocPhanById(String maHP, HocPhan hocPhan) {
        hocPhan.setMaHocPhan(maHP);
        return hocPhanRepository.save(hocPhan);
    }

    @Override
    public List<HocPhan> findHPByMaHK(long maHK) {
        return hocPhanRepository.findHPByMaHK(maHK);
    }

    @Override
    public void saveHocPhanByFile(MultipartFile file) {
        try {
            List<HocPhan> hocPhanList = ExcelHelperHocPhan.excelToTutorials(file.getInputStream());
            hocPhanRepository.saveAll(hocPhanList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
}

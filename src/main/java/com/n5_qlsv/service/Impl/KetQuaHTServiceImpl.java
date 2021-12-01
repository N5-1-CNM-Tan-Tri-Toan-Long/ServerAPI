package com.n5_qlsv.service.Impl;

import com.n5_qlsv.entity.KetQuaHocTap;
import com.n5_qlsv.entity.LopHocPhan;
import com.n5_qlsv.helper.ExcelHelperKetQuaHocTap;
import com.n5_qlsv.repository.KetQuaHocTapRepository;
import com.n5_qlsv.service.KetQuaHTService;
import com.n5_qlsv.service.LopHocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

@Service
public class KetQuaHTServiceImpl implements KetQuaHTService {

    @Autowired
    private KetQuaHocTapRepository ketQuaHocTapRepository;

    @Autowired
    private LopHocPhanService lopHocPhanService;

    @Override
    public KetQuaHocTap saveKQHT(KetQuaHocTap ketQuaHocTap) {
        ketQuaHocTap.setMaKQHT(0);
        //Xử lý tính điểm học tập.
        //tinh điểm môn lý thuyêt
        LopHocPhan lopHocPhan = lopHocPhanService.findLopHocPhanById(ketQuaHocTap.getLopHocPhan().getMaLHP());
        Double tk;
        if (ketQuaHocTap.getDiemTK1() != null){
            if(ketQuaHocTap.getDiemTK2() != null && ketQuaHocTap.getDiemTK3() != null){
                tk = ((ketQuaHocTap.getDiemTK1() + ketQuaHocTap.getDiemTK2() + ketQuaHocTap.getDiemTK3()))/3;
            }else if(ketQuaHocTap.getDiemTK2() != null){
                tk = ((ketQuaHocTap.getDiemTK1() + ketQuaHocTap.getDiemTK2()))/2;
            }else {
                tk = ketQuaHocTap.getDiemTK1();
            }
        }else {
            tk = null;
        }
        double gk = ketQuaHocTap.getDiemGK();
        ketQuaHocTap.setDiemGK((double)Math.round(gk * 10) / 10);
        double ck = ketQuaHocTap.getDiemCK();
        ketQuaHocTap.setDiemCK((double)Math.round(ck * 10) / 10);
        double diemHe10 = ((tk*20) + (gk * 30) + (ck* 50 )) / 100;
        int soTCLT = lopHocPhan.getHocPhan().getSoTCLT();
        int soTCTH = lopHocPhan.getHocPhan().getSoTCTH();
        int soTC = lopHocPhan.getHocPhan().getSoTCLT() + lopHocPhan.getHocPhan().getSoTCTH();
        double diemTongKet = 0;
        if(ketQuaHocTap.getDiemTH1() == null && ketQuaHocTap.getDiemTH2() == null){ // môn không có thực hành
            double diemHe10LT = (double) Math.round(diemHe10 * 100) / 100;
            diemTongKet = (double) Math.round(diemHe10LT * 10) / 10;
            ketQuaHocTap.setDiemHe10(diemTongKet);
        }else {
            if(ketQuaHocTap.getDiemTH1() != null){
                if(ketQuaHocTap.getDiemTH2() == null){
                    double diemMonTH = ((diemHe10 * soTCLT) + (ketQuaHocTap.getDiemTH1() * soTCTH)) / soTC;
                    double diemMotMonTH = (double) Math.round(diemMonTH * 100) / 100;
                    diemTongKet = (double) Math.round(diemMotMonTH * 10) / 10;
                    ketQuaHocTap.setDiemHe10(diemTongKet);
                }else {
                    double diemTBTH = ((ketQuaHocTap.getDiemTH1() + ketQuaHocTap.getDiemTH2()))/2;
                    double diemMonTH = ((diemHe10 * soTCLT) + (diemTBTH * soTCTH)) / soTC;
                    double diemHaiMonTH = (double) Math.round(diemMonTH * 100) / 100;
                    diemTongKet = (double) Math.round(diemHaiMonTH * 10) / 10;
                    ketQuaHocTap.setDiemHe10(diemTongKet);
                }
            }
        }
        //điểm hệ số 4
        if(diemTongKet >= 9){
            ketQuaHocTap.setDiemHe4(4.0);
            ketQuaHocTap.setDiemChu("A+");
            ketQuaHocTap.setXepLoai("Xuất sắc");
        }else if(diemTongKet > 8.4 && diemTongKet <= 8.9){
            ketQuaHocTap.setDiemHe4(3.8);
            ketQuaHocTap.setDiemChu("A");
            ketQuaHocTap.setXepLoai("Giỏi");
        }else if(diemTongKet > 7.9 && diemTongKet <= 8.4){
            ketQuaHocTap.setDiemHe4(3.5);
            ketQuaHocTap.setDiemChu("B+");
            ketQuaHocTap.setXepLoai("Khá");
        }else if(diemTongKet > 6.9 && diemTongKet <= 7.9){
            ketQuaHocTap.setDiemHe4(3.0);
            ketQuaHocTap.setDiemChu("B");
            ketQuaHocTap.setXepLoai("Khá");
        }else if(diemTongKet > 5.9 && diemTongKet <= 6.9){
            ketQuaHocTap.setDiemHe4(2.5);
            ketQuaHocTap.setDiemChu("C+");
            ketQuaHocTap.setXepLoai("Trung Bình");
        }else if(diemTongKet > 5.4 && diemTongKet <= 5.9){
            ketQuaHocTap.setDiemHe4(2.0);
            ketQuaHocTap.setDiemChu("C");
            ketQuaHocTap.setXepLoai("Trung Bình");
        }else if(diemTongKet > 4.9 && diemTongKet <= 5.4){
            ketQuaHocTap.setDiemHe4(1.5);
            ketQuaHocTap.setDiemChu("D+");
            ketQuaHocTap.setXepLoai("Trung Bình Yếu");
        }
        else if(diemTongKet > 3.9 && diemTongKet <= 4.9){
            ketQuaHocTap.setDiemHe4(1.0);
            ketQuaHocTap.setDiemChu("D");
            ketQuaHocTap.setXepLoai("Trung Bình Yếu");
        }else {
            ketQuaHocTap.setDiemHe4(0.0);
            ketQuaHocTap.setDiemChu("F");
            ketQuaHocTap.setXepLoai("Kém");
            ketQuaHocTap.setMoTa("Học lại");
        }
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
        LopHocPhan lopHocPhan = lopHocPhanService.findLopHocPhanById(ketQuaHocTap.getLopHocPhan().getMaLHP());
        Double tk;
        if (ketQuaHocTap.getDiemTK1() != null){
            if(ketQuaHocTap.getDiemTK2() != null && ketQuaHocTap.getDiemTK3() != null){
                tk = ((ketQuaHocTap.getDiemTK1() + ketQuaHocTap.getDiemTK2() + ketQuaHocTap.getDiemTK3()))/3;
            }else if(ketQuaHocTap.getDiemTK2() != null && ketQuaHocTap.getDiemTK3() == null){
                tk = ((ketQuaHocTap.getDiemTK1() + ketQuaHocTap.getDiemTK2()))/2;
            }else {
                tk = ketQuaHocTap.getDiemTK1();
            }
        }else {
            tk = null;
        }
        double gk = ketQuaHocTap.getDiemGK();
        ketQuaHocTap.setDiemGK(Math.ceil(gk * 10) / 10);
        double ck = ketQuaHocTap.getDiemCK();
        ketQuaHocTap.setDiemCK(Math.ceil(ck * 10) / 10);
        double diemHe10 = ((tk*20) + (gk * 30) + (ck* 50 ))/100;
        int soTCLT = lopHocPhan.getHocPhan().getSoTCLT();
        int soTCTH = lopHocPhan.getHocPhan().getSoTCTH();
        int soTC = lopHocPhan.getHocPhan().getSoTCLT() + lopHocPhan.getHocPhan().getSoTCTH();
        double diemTongKet = 0;
        if(ketQuaHocTap.getDiemTH1() == null && ketQuaHocTap.getDiemTH2() == null){ // mon có thực hành
            diemTongKet = Math.ceil(diemHe10 * 10) / 10;
            ketQuaHocTap.setDiemHe10(diemTongKet);
        }else {
            if(ketQuaHocTap.getDiemTK1() != null){
                if(ketQuaHocTap.getDiemTH2() == null){
                    double diemMonTH = ((diemHe10 * soTCLT) + (ketQuaHocTap.getDiemTH1() * soTCTH)) / soTC;
                    diemTongKet = Math.ceil(diemMonTH * 100) / 100;
                    ketQuaHocTap.setDiemHe10(diemTongKet);
                }else {
                    double diemTBTH = ((ketQuaHocTap.getDiemTH1() + ketQuaHocTap.getDiemTH2()))/2;
                    double diemMonTH = ((diemHe10 * soTCLT) + (diemTBTH * soTCTH)) / soTC;
                    diemTongKet = Math.ceil(diemMonTH * 10) / 10;
                    ketQuaHocTap.setDiemHe10(diemTongKet);
                }
            }

        }

        //điểm hệ số 4
        if(diemTongKet >= 9){
            ketQuaHocTap.setDiemHe4(4.0);
            ketQuaHocTap.setDiemChu("A+");
            ketQuaHocTap.setXepLoai("Xuất sắc");
        }else if(diemTongKet > 8.4 && diemTongKet <= 8.9){
            ketQuaHocTap.setDiemHe4(3.8);
            ketQuaHocTap.setDiemChu("A");
            ketQuaHocTap.setXepLoai("Giỏi");
        }else if(diemTongKet > 7.9 && diemTongKet <= 8.4){
            ketQuaHocTap.setDiemHe4(3.5);
            ketQuaHocTap.setDiemChu("B+");
            ketQuaHocTap.setXepLoai("Khá");
        }else if(diemTongKet > 6.9 && diemTongKet <= 7.9){
            ketQuaHocTap.setDiemHe4(3.0);
            ketQuaHocTap.setDiemChu("B");
            ketQuaHocTap.setXepLoai("Khá");
        }else if(diemTongKet > 5.9 && diemTongKet <= 6.9){
            ketQuaHocTap.setDiemHe4(2.5);
            ketQuaHocTap.setDiemChu("C+");
            ketQuaHocTap.setXepLoai("Trung Bình");
        }else if(diemTongKet > 5.4 && diemTongKet <= 5.9){
            ketQuaHocTap.setDiemHe4(2.0);
            ketQuaHocTap.setDiemChu("C");
            ketQuaHocTap.setXepLoai("Trung Bình");
        }else if(diemTongKet > 4.9 && diemTongKet <= 5.4){
            ketQuaHocTap.setDiemHe4(1.5);
            ketQuaHocTap.setDiemChu("D+");
            ketQuaHocTap.setXepLoai("Trung Bình Yếu");
        }
        else if(diemTongKet > 3.9 && diemTongKet <= 4.9){
            ketQuaHocTap.setDiemHe4(1.0);
            ketQuaHocTap.setDiemChu("D");
            ketQuaHocTap.setXepLoai("Trung Bình Yếu");
        }else {
            ketQuaHocTap.setDiemHe4(0.0);
            ketQuaHocTap.setDiemChu("F");
            ketQuaHocTap.setXepLoai("Kém");
            ketQuaHocTap.setMoTa("Học lại");
        }
        return ketQuaHocTapRepository.save(ketQuaHocTap);
    }

    @Override
    public List<KetQuaHocTap> findKQHTByMaSV(String maSV) {
        return ketQuaHocTapRepository.findKQHTByMaSV(maSV);
    }

    @Override
    public List<KetQuaHocTap> findKQHTByMaSVWithPageSize(String maSV, int page, int size) {
        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page,size);
        return ketQuaHocTapRepository.findKQHTByMaSVWithPageSize(maSV, pageable);
    }

    @Override
    public Set<Long> findMaHKByMaSV(String maSV) {
        return ketQuaHocTapRepository.findMaHKByMaSV(maSV);
    }

    @Override
    public KetQuaHocTap findKQHTByMaSVAndMaLHP(String maSV, Long maLHP) {
        return ketQuaHocTapRepository.findKQHTByMaSVAndMaLHP(maSV, maLHP);
    }

    @Override
    public void saveKetQuaHocTapByFile(MultipartFile file) {
        try {
            List<KetQuaHocTap> ketQuaHocTaps = ExcelHelperKetQuaHocTap.excelToKetQuaHocTap(file.getInputStream());
            for (KetQuaHocTap ketQuaHocTap: ketQuaHocTaps) {
                saveKQHT(ketQuaHocTap);
            }
//            ketQuaHocTapRepository.saveAll(ketQuaHocTaps);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    @Override
    public List<KetQuaHocTap> findKQHYByMaLHP(Long maLHP) {
        return ketQuaHocTapRepository.findKQHYByMaLHP(maLHP);
    }
}

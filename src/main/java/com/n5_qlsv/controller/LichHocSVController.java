package com.n5_qlsv.controller;

import com.n5_qlsv.entity.LichHocSinhVien;
import com.n5_qlsv.service.LichHocSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lichhocSV")
public class LichHocSVController {

    @Autowired
    private LichHocSVService lichHocSVService;

    @GetMapping("/masv/{maSV}")
    public List<LichHocSinhVien> findByMaSV(@PathVariable("maSV") long maSV){
        return lichHocSVService.findByMaSV(maSV);
    }

    @GetMapping
    public List<LichHocSinhVien> findAllLichHocSV(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam (defaultValue = "0") int size){
        return lichHocSVService.findAllLichHocSinhVien(page, size);
    }
    @GetMapping("/{id}")
    public LichHocSinhVien getLichHocSVById(@PathVariable("id") Long maLHSV){
        return lichHocSVService.findLichHocSinhVienById(maLHSV);
    }

    @PostMapping
    public LichHocSinhVien saveLichHocSinhVien(@RequestBody LichHocSinhVien lichHocSinhVien){
        return lichHocSVService.saveLichHocSinhVien(lichHocSinhVien);
    }

    @PutMapping("/{id}")
    public LichHocSinhVien updateLichHocSinhVien(@RequestBody LichHocSinhVien lichHocSinhVien, @PathVariable ("id") Long maLHSV){
        return lichHocSVService.updateLichHocSinhVienById(maLHSV, lichHocSinhVien);
    }

    @DeleteMapping("/{id}")
    public void deleteLichHocSVById(@PathVariable("id") Long maLHSV){
        lichHocSVService.deleteLichHocSinhVienById(maLHSV);
    }
}

package com.n5_qlsv.controller;

import com.n5_qlsv.entity.SinhVien;
import com.n5_qlsv.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinhviens")

public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping
    public List<SinhVien> getAllSinhVien(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size) {
        return sinhVienService.findAllSinhVien(page, size);
    }

    @GetMapping("/{id}")
    public SinhVien getSinhVienById(@PathVariable("id") String id) {
        return sinhVienService.findSinhVienById(id);
    }

    @GetMapping("/{id}/role")
    public String getRoleNameById(@PathVariable("id") String id) {
        return sinhVienService.findRoleNameByMaSV(id);
    }

    @PostMapping
    public SinhVien saveSinhVien(@RequestBody SinhVien sinhVien) {
        return sinhVienService.saveSinhVien(sinhVien);
    }

    @PutMapping("/{id}")
    public SinhVien updateSinhVien(@RequestBody SinhVien sinhVien, @PathVariable("id") String id) {
        return sinhVienService.updateSinhVienById(id, sinhVien);
    }

    @DeleteMapping("/{id}")
    public void deleteSinhVienById(@PathVariable("id") String id) {
        sinhVienService.deleteSinhVienById(id);
    }

    @GetMapping("/keyword={keyword}")
    public List<SinhVien> searchAllSinhViensByKeyword(@PathVariable(value = "keyword") String keyword
            , @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size) {
        return sinhVienService.search(keyword, page, size);
    }

    @GetMapping("/khoa={maKhoa}")
    public  List<SinhVien> findAllSinhViensByKhoa(@PathVariable(value = "maKhoa") Long maKhoa,
                                                  @RequestParam (defaultValue = "0") int page,
                                                  @RequestParam (defaultValue = "0") int size){
        return sinhVienService.findAllSinhViensByKhoa(maKhoa, page, size);
    }
}

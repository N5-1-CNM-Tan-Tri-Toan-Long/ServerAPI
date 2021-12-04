package com.n5_qlsv.controller;

import com.n5_qlsv.entity.HocPhanKhung;
import com.n5_qlsv.service.HocPhanKhungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/hocphankhung")
public class HocPhanKhungController {

    @Autowired
    private HocPhanKhungService service;

    @GetMapping
    public List<HocPhanKhung> findAll(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size) {
        return service.findAllHPK(page, size);
    }

    @GetMapping("/chuyenNganh/{maCN}/thuTuHocKi/{tthk}")
    public List<HocPhanKhung> findAllByChuyenNganhAndHocKi(@PathVariable long maCN
            , @PathVariable int tthk) {
        return service.findAllByChuyenNganhAndHocKi(maCN, tthk);
    }

    @GetMapping("/chuyenNganh/{maCN}")
    public List<HocPhanKhung> findAllByChuyenNganh(@PathVariable long maCN){
        return service.findAllByChuyenNganh(maCN);
    }

    @GetMapping("/{id}")
    public HocPhanKhung getById(@PathVariable("id") Long id) {
        return service.findHPKById(id);
    }

    @PostMapping
    public HocPhanKhung save(@RequestBody HocPhanKhung khoa) {
        return service.saveHPK(khoa);
    }

    @PutMapping("/{id}")
    public HocPhanKhung update(@RequestBody HocPhanKhung khoa, @PathVariable("id") Long id) {
        return service.updateHPKById(id, khoa);
    }

    @DeleteMapping("/{id}")
    public void deleteKhoaById(@PathVariable("id") Long id) {
        service.deleteHPKById(id);
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        service.saveHPKByFile(file);
    }
}

package com.n5_qlsv.controller;

import com.n5_qlsv.entity.ChuyenNganh;
import com.n5_qlsv.entity.SinhVien;
import com.n5_qlsv.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/chuyennganh")
public class ChuyenNganhController {

    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @GetMapping
    public List<ChuyenNganh> findAllChuyenNganh(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size) {
        return chuyenNganhService.findAllChuyenNganh(page, size);
    }

    @GetMapping("/{id}")
    public ChuyenNganh getChuyenNganhById(@PathVariable("id") Long id) {
        return chuyenNganhService.findChuyenNganhById(id);
    }

    @PostMapping
    public ChuyenNganh saveChuyenNganh(@RequestBody ChuyenNganh chuyenNganh) {
        return chuyenNganhService.saveChuyenNganh(chuyenNganh);
    }

    @PutMapping("/{id}")
    public ChuyenNganh updateChuyenNganh(@RequestBody ChuyenNganh chuyenNganh, @PathVariable("id") Long id) {
        return chuyenNganhService.updateChuyenNganhById(id, chuyenNganh);
    }

    @DeleteMapping("/{id}")
    public void deleteHocKyById(@PathVariable("id") Long id) {
        chuyenNganhService.deleteChuyenNganhById(id);
    }

    @GetMapping("/khoa={maKhoa}")
    public List<ChuyenNganh> findAllByKhoa(@PathVariable(value = "maKhoa") Long maKhoa,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "0") int size) {
        return chuyenNganhService.findAllByKhoa(maKhoa, page, size);
    }
    
    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        chuyenNganhService.saveChuyenNganhByFile(file);
    }
}

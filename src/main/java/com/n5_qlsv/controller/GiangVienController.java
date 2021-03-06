package com.n5_qlsv.controller;

import com.n5_qlsv.entity.GiangVien;
import com.n5_qlsv.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/giangvien")
public class GiangVienController {

    @Autowired
    private GiangVienService giangVienService;

    @GetMapping
    public List<GiangVien> findAllGiangVien(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size) {
        return giangVienService.findAllGiangVien(page, size);
    }

    @GetMapping("/{id}")
    public GiangVien getGiangVienById(@PathVariable("id") Long id) {
        return giangVienService.findGiangVienById(id);
    }

    @PostMapping
    public GiangVien saveGiangVien(@RequestBody GiangVien giangVien) {
        return giangVienService.saveGiangVien(giangVien);
    }

    @PutMapping("/{id}")
    public GiangVien updateGiangVien(@RequestBody GiangVien giangVien, @PathVariable("id") Long id) {
        return giangVienService.updateGiangVienById(id, giangVien);
    }

    @DeleteMapping("/{id}")
    public void deleteGiangVienById(@PathVariable("id") Long id) {
        giangVienService.deleteGiangVienById(id);
    }

    @PostMapping("/upload")
    public void  uploadFile(@RequestParam("file") MultipartFile file) {
        giangVienService.saveGiangVienByFile(file);
    }
}

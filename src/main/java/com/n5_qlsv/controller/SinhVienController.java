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
    public List<SinhVien> getAllSinhVien(){
        return sinhVienService.findAllSinhVien();
    }

    @GetMapping("/{id}")
    public SinhVien getSinhVienById(@PathVariable("id") Long id){
        return sinhVienService.findSinhVienById(id);
    }

    @PostMapping
    public SinhVien saveSinhVien(@RequestBody SinhVien sinhVien){
        return sinhVienService.saveSinhVien(sinhVien);
    }

    @PutMapping("/{id}")
    public SinhVien updateSinhVien(@RequestBody SinhVien sinhVien, @PathVariable ("id") Long id){
        return sinhVienService.updateSinhVienById(id, sinhVien);
    }

    @DeleteMapping("/{id}")
    public void deleteSinhVienById(@PathVariable("id") Long id){
        sinhVienService.deleteSinhVienById(id);
    }
}

package com.n5_qlsv.controller;

import com.n5_qlsv.entity.Khoa;
import com.n5_qlsv.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khoa")
public class KhoaController {

    @Autowired
    private KhoaService khoaService;

    @GetMapping
    public List<Khoa> findAllKhoa(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size) {
        return khoaService.findAllKhoa(page, size);
    }

    @GetMapping("/{id}")
    public Khoa getKhoaById(@PathVariable("id") Long id) {
        return khoaService.findKhoaById(id);
    }

    @PostMapping
    public Khoa saveKhoa(@RequestBody Khoa khoa) {
        return khoaService.saveKhoa(khoa);
    }

    @PutMapping("/{id}")
    public Khoa updateKhoa(@RequestBody Khoa khoa, @PathVariable("id") Long id) {
        return khoaService.updateKhoaById(id, khoa);
    }

    @DeleteMapping("/{id}")
    public void deleteKhoaById(@PathVariable("id") Long id) {
        khoaService.deleteKhoaById(id);
    }

}

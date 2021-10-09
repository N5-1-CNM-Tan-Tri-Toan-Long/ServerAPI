package com.n5_qlsv.controller;


import com.n5_qlsv.entity.LopHoc;
import com.n5_qlsv.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lophoc")
public class LopHocController {

    @Autowired
    private LopHocService lopHocService;

    @GetMapping
    public List<LopHoc> findAllLopHoc(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size) {
        return lopHocService.findAllLopHoc(page, size);
    }

    @GetMapping("/{id}")
    public LopHoc getLopHocById(@PathVariable("id") Long id) {
        return lopHocService.findLopHocById(id);
    }

    @PostMapping
    public LopHoc saveLopHoc(@RequestBody LopHoc lopHoc) {
        return lopHocService.saveLopHoc(lopHoc);
    }

    @PutMapping("/{id}")
    public LopHoc updateLopHoc(@RequestBody LopHoc lopHoc, @PathVariable("id") Long id) {
        return lopHocService.updateLopHocById(id, lopHoc);
    }

    @DeleteMapping("/{id}")
    public void deleteLopHocById(@PathVariable("id") Long id) {
        lopHocService.deleteLopHocById(id);
    }
}

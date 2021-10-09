package com.n5_qlsv.controller;

import com.n5_qlsv.entity.LichHoc;
import com.n5_qlsv.service.LichHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lichhoc")
public class LichHocController {

    @Autowired
    private LichHocService lichHocService;

    @GetMapping
    public List<LichHoc> findAllLichHoc(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam (defaultValue = "0") int size){
        return lichHocService.findAllLichHoc(page, size);
    }
    @GetMapping("/{id}")
    public LichHoc getLichHocById(@PathVariable("id") Long maLH){
        return lichHocService.findLichHocById(maLH);
    }

    @PostMapping
    public LichHoc saveLichHoc(@RequestBody LichHoc lichHoc){
        return lichHocService.saveLichHoc(lichHoc);
    }

    @PutMapping("/{id}")
    public LichHoc updateLichHoc(@RequestBody LichHoc lichHoc, @PathVariable("id") Long maLH){
        return lichHocService.updateLichHocById(maLH, lichHoc);
    }

    @DeleteMapping("/{id}")
    public void deleteLichHoc(@PathVariable("id") Long maLH){
        lichHocService.deleteLichHocById(maLH);
    }
}

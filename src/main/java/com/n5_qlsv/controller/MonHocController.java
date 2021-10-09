package com.n5_qlsv.controller;

import com.n5_qlsv.entity.MonHoc;
import com.n5_qlsv.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monhoc")
public class MonHocController {

    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public List<MonHoc> findAllMonHoc(@RequestParam (defaultValue = "0") int page
            , @RequestParam (defaultValue = "0") int size){
        return monHocService.findAllMonHoc(page, size);
    }

    @GetMapping("/{id}")
    public MonHoc getMonHocById(@PathVariable("id") Long id){
        return monHocService.findMonHocById(id);
    }

    @PostMapping
    public MonHoc saveMonHoc(@RequestBody MonHoc hocKy){
        return monHocService.saveMonHoc(hocKy);
    }

    @PutMapping("/{id}")
    public MonHoc updateMonHoc(@RequestBody MonHoc hocKy, @PathVariable ("id") Long id){
        return monHocService.updateMonHocById(id, hocKy);
    }

    @DeleteMapping("/{id}")
    public void deleteMonHocById(@PathVariable("id") Long id){
        monHocService.deleteMonHocById(id);
    }
}

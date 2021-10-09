package com.n5_qlsv.controller;

import com.n5_qlsv.entity.LopHocPhan;
import com.n5_qlsv.service.LopHocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lophocphan")
public class LopHocPhanController {

    @Autowired
    private LopHocPhanService lopHocPhanService;

    @GetMapping
    public List<LopHocPhan> findAllLopHocPhan(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam (defaultValue = "0") int size){
        return lopHocPhanService.findAllLopHocPhan(page, size);
    }
    @GetMapping("/{id}")
    public LopHocPhan getLopHocPhanById(@PathVariable("id") Long id){
        return lopHocPhanService.findLopHocPhanById(id);
    }

    @PostMapping
    public LopHocPhan saveLopHocPhan(@RequestBody LopHocPhan lopHocPhan){
        return lopHocPhanService.saveLopHocPhan(lopHocPhan);
    }

    @PutMapping("/{id}")
    public LopHocPhan updateLopHocPhan(@RequestBody LopHocPhan lopHocPhan, @PathVariable("id") Long id){
        return lopHocPhanService.updateLopHocPhanById(id, lopHocPhan);
    }

    @DeleteMapping("/{id}")
    public void deleteHocPhanById(@PathVariable("id") Long id){
        lopHocPhanService.deleteLopHocPhanById(id);
    }
}

package com.n5_qlsv.controller;

import com.n5_qlsv.entity.HocPhan;
import com.n5_qlsv.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hocphan")
public class HocPhanController {

    @Autowired
    private HocPhanService hocPhanService;

    @GetMapping
    public List<HocPhan> findAllLopHoc(@RequestParam (defaultValue = "0") int page,
                                       @RequestParam (defaultValue = "0") int size){
        return hocPhanService.findAllHocPhan(page, size);
    }

    @GetMapping("/{id}")
    public HocPhan getLopHocById(@PathVariable("id") Long id){
        return hocPhanService.findHocPhanById(id);
    }

    @PostMapping
    public HocPhan saveLopHoc(@RequestBody HocPhan lopHoc){
        return hocPhanService.saveHocPhan(lopHoc);
    }

    @PutMapping("/{id}")
    public HocPhan updateLopHoc(@RequestBody HocPhan lopHoc, @PathVariable ("id") Long id){
        return hocPhanService.updateHocPhanById(id, lopHoc);
    }

    @DeleteMapping("/{id}")
    public void deleteLopHocById(@PathVariable("id") Long id){
        hocPhanService.deleteHocPhanById(id);
    }
}

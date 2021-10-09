package com.n5_qlsv.controller;

import com.n5_qlsv.entity.HocKy;
import com.n5_qlsv.service.HocKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hocky")
public class HocKyController {

    @Autowired
    private HocKyService hocKyService;

    @GetMapping
    public List<HocKy> findAllHocKy(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size) {
        return hocKyService.findAllHocKy(page, size);
    }

    @GetMapping("/{id}")
    public HocKy getHocKyById(@PathVariable("id") Long id) {
        return hocKyService.findHocKyById(id);
    }

    @PostMapping
    public HocKy saveHocKy(@RequestBody HocKy hocKy) {
        return hocKyService.saveHocKy(hocKy);
    }

    @PutMapping("/{id}")
    public HocKy updateHocKy(@RequestBody HocKy hocKy, @PathVariable("id") Long id) {
        return hocKyService.updateHocKyById(id, hocKy);
    }

    @DeleteMapping("/{id}")
    public void deleteHocKyById(@PathVariable("id") Long id) {
        hocKyService.deleteHocKyById(id);
    }
}

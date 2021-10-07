package com.n5_qlsv.controller;

import com.n5_qlsv.entity.HocKy;
import com.n5_qlsv.entity.User;
import com.n5_qlsv.service.HocKyService;
import com.n5_qlsv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hocky")
public class HocKyController {

    @Autowired
    private HocKyService hocKyService;

    @GetMapping
    public List<HocKy> findAllHocKy(){
        return hocKyService.findAllHocKy();
    }

    @GetMapping("/{id}")
    public HocKy getHocKyById(@PathVariable("id") Long id){
        return hocKyService.findHocKyById(id);
    }

    @PostMapping
    public HocKy saveHocKy(@RequestBody HocKy hocKy){
        return hocKyService.saveHocKy(hocKy);
    }

    @PutMapping("/{id}")
    public HocKy updateHocKy(@RequestBody HocKy hocKy, @PathVariable ("id") Long id){
        return hocKyService.updateHocKyById(id, hocKy);
    }

    @DeleteMapping("/{id}")
    public void deleteHocKyById(@PathVariable("id") Long id){
        hocKyService.deleteHocKyById(id);
    }
}

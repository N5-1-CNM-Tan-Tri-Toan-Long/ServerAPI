package com.n5_qlsv.controller;

import com.n5_qlsv.entity.ChiTietLopHocPhan;
import com.n5_qlsv.service.CTLHPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chitietlhp")
public class CTLHPController {

    @Autowired
    private CTLHPService ctlhpService;

    @GetMapping
    public List<ChiTietLopHocPhan> findAllCTLHP(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam (defaultValue = "0") int size){
        return ctlhpService.findAllChiTietLHP(page, size);
    }

    @GetMapping("/{id}")
    public ChiTietLopHocPhan getCTLHPById(@PathVariable("id") Long maCTLHP){
        return ctlhpService.findChiTietLHPById(maCTLHP);
    }
    @PostMapping
    public ChiTietLopHocPhan saveCTLHP(@RequestBody ChiTietLopHocPhan chiTietLopHocPhan){
        return ctlhpService.saveChiTietLHP(chiTietLopHocPhan);
    }

    @PutMapping("/{id}")
    public ChiTietLopHocPhan updateCTLHP(@RequestBody ChiTietLopHocPhan chiTietLopHocPhan,
                                         @PathVariable("id") Long maCTLHP){
        return ctlhpService.updateChiTietLHPById(maCTLHP, chiTietLopHocPhan);
    }
    @DeleteMapping("/{id}")
    public void deleteCTLHPById(@PathVariable("id") Long maCTLHP){
        ctlhpService.deleteChiTietLHPById(maCTLHP);
    }
}

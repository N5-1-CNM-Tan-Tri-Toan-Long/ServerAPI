package com.n5_qlsv.controller;

import com.n5_qlsv.entity.ChiTietLopHocPhan;
import com.n5_qlsv.entity.LopHocPhan;
import com.n5_qlsv.service.CTLHPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CTLHP")
public class CTLHPController {

    @Autowired
    private CTLHPService ctlhpService;

    @GetMapping("/{id}")
    public ChiTietLopHocPhan getCTLHPById(@PathVariable("id") Long maCTLHP){
        return ctlhpService.findChiTietLHPById(maCTLHP);
    }

    @PutMapping("/{id}")
    public ChiTietLopHocPhan updateCTLHP(@RequestBody ChiTietLopHocPhan chiTietLopHocPhan, @PathVariable("id") Long id){
        return ctlhpService.updateChiTietLHPById(id, chiTietLopHocPhan);
    }

    @DeleteMapping("/{id}")
    public void deleteCTLHPById(@PathVariable("id") Long maCTLHP){
        ctlhpService.deleteChiTietLHPById(maCTLHP);
    }

    @GetMapping("/malophocphan/{maLHP}")
    private List<ChiTietLopHocPhan> findByMaLHP(@PathVariable("maLHP") long maLHP){
        return ctlhpService.findByMaLHP(maLHP);
    };
}

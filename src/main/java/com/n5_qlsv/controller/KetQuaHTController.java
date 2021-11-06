package com.n5_qlsv.controller;

import com.n5_qlsv.entity.KetQuaHocTap;
import com.n5_qlsv.service.KetQuaHTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ketquahoctap")
public class KetQuaHTController {

    @Autowired
    private KetQuaHTService ketQuaHTService;

    @GetMapping
    public List<KetQuaHocTap> findAllKQHT(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam (defaultValue = "0") int size){
        return ketQuaHTService.findAllKQHT(page, size);
    }
    @GetMapping("/{id}")
    public KetQuaHocTap getKQHTById(@PathVariable("id") Long maKQHT){
        return ketQuaHTService.findKQHTById(maKQHT);
    }

    @PostMapping
    public KetQuaHocTap saveKQHT(@RequestBody KetQuaHocTap ketQuaHocTap){
        return ketQuaHTService.saveKQHT(ketQuaHocTap);
    }

    @PutMapping("/{id}")
    public KetQuaHocTap updateKQHT(@RequestBody KetQuaHocTap ketQuaHocTap, @PathVariable ("id") Long maKQHT){
        return ketQuaHTService.updateKQHTById(maKQHT, ketQuaHocTap);
    }

    @GetMapping("/{maSV}/masv")
    public List<KetQuaHocTap> findKQHTByMaSV(@PathVariable("maSV") String maSV){
        return ketQuaHTService.findKQHTByMaSV(maSV);
    }

    @GetMapping("/{maSV}/hk")
    public Set<Long> findMaHKByMaSV(@PathVariable("maSV") String maSV){
        return ketQuaHTService.findMaHKByMaSV(maSV);
    }

}

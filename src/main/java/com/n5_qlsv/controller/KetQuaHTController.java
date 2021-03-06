package com.n5_qlsv.controller;

import com.n5_qlsv.entity.KetQuaHocTap;
import com.n5_qlsv.service.KetQuaHTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/maSV={maSV}")
    public List<KetQuaHocTap> findKQHTByMaSVWithPageSize(@PathVariable("maSV") String maSV,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam (defaultValue = "0") int size){
        return ketQuaHTService.findKQHTByMaSVWithPageSize(maSV, page, size);
    }

    @GetMapping("/{maSV}/hk")
    public Set<Long> findMaHKByMaSV(@PathVariable("maSV") String maSV){
        return ketQuaHTService.findMaHKByMaSV(maSV);
    }
    @DeleteMapping("/{maKQHT}")
    public void deleteKQHT(@PathVariable("maKQHT") Long maKQHT){
        ketQuaHTService.deleteKQHTById(maKQHT);
    }

    @GetMapping("/{maSV}/{maLHP}/kq")
    public KetQuaHocTap findKQHTByMaSVAndMaLHP(@PathVariable("maSV") String maSV, @PathVariable("maLHP") Long maLHP){
        return ketQuaHTService.findKQHTByMaSVAndMaLHP(maSV, maLHP);
    }

    @PostMapping("/upload")
    public void  uploadFile(@RequestParam("file") MultipartFile file) {
        ketQuaHTService.saveKetQuaHocTapByFile(file);
    }

    @GetMapping("/{maLHP}/kq")
    public List<KetQuaHocTap> findKQHYByMaLHP(@PathVariable("maLHP") Long maLHP){
        return ketQuaHTService.findKQHYByMaLHP(maLHP);
    }
}

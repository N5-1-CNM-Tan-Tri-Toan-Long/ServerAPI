package com.n5_qlsv.controller;

import com.n5_qlsv.entity.ChuyenNganh;
import com.n5_qlsv.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chuyennganh")
public class ChuyenNganhController {

    @Autowired
    private ChuyenNganhService chuyenNganhService;

    @GetMapping
    public List<ChuyenNganh> findAllChuyenNganh(){
        return chuyenNganhService.findAllChuyenNganh();
    }

    @GetMapping("/{id}")
    public ChuyenNganh getChuyenNganhById(@PathVariable("id") Long id){
        return chuyenNganhService.findChuyenNganhById(id);
    }

    @PostMapping
    public ChuyenNganh saveChuyenNganh(@RequestBody ChuyenNganh chuyenNganh){
        return chuyenNganhService.saveChuyenNganh(chuyenNganh);
    }

    @PutMapping("/{id}")
    public ChuyenNganh updateChuyenNganh(@RequestBody ChuyenNganh chuyenNganh, @PathVariable ("id") Long id){
        return chuyenNganhService.updateChuyenNganhById(id, chuyenNganh);
    }

    @DeleteMapping("/{id}")
    public void deleteHocKyById(@PathVariable("id") Long id){
        chuyenNganhService.deleteChuyenNganhById(id);
    }

}

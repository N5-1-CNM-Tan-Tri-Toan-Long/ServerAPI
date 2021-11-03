package com.n5_qlsv.controller;

import com.n5_qlsv.entity.HocKy;
import com.n5_qlsv.helper.ExcelHelper;
import com.n5_qlsv.message.ResponseMessage;
import com.n5_qlsv.service.HocKyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                hocKyService.saveHocKyByFile(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}

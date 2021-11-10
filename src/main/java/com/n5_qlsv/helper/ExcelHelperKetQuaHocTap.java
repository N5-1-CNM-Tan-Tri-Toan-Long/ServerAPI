package com.n5_qlsv.helper;

import com.n5_qlsv.entity.KetQuaHocTap;
import com.n5_qlsv.entity.LopHocPhan;
import com.n5_qlsv.entity.SinhVien;
import com.n5_qlsv.service.LopHocPhanService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelperKetQuaHocTap {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "KetQuaHocTap";

    @Autowired
    private static LopHocPhanService lopHocPhanService;

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<KetQuaHocTap> excelToKetQuaHocTap(InputStream is){
        try{
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<KetQuaHocTap> ketQuaHocTaps = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()){
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();
                KetQuaHocTap ketQuaHocTap = new KetQuaHocTap();
                int cellIdx = 0;
                while (cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx){
                        case 0:
                            ketQuaHocTap.setDiemCK(currentCell.getNumericCellValue());
                            break;
                        case 1:
                            ketQuaHocTap.setDiemGK(currentCell.getNumericCellValue());
                            break;
                        case 2:
                            ketQuaHocTap.setDiemTH1(currentCell.getNumericCellValue());
                            break;
                        case 3:
                            ketQuaHocTap.setDiemTH2(currentCell.getNumericCellValue());
                            break;
                        case 4:
                            ketQuaHocTap.setDiemTK1(currentCell.getNumericCellValue());
                            break;
                        case 5:
                            ketQuaHocTap.setDiemTK2(currentCell.getNumericCellValue());
                            break;
                        case 6:
                            ketQuaHocTap.setDiemTK3(currentCell.getNumericCellValue());
                            break;
                        case 7:
                            ketQuaHocTap.setLopHocPhan(new LopHocPhan().builder().maLHP((long)currentCell.getNumericCellValue()).build());
                            break;
                        case 8:
                            ketQuaHocTap.setSinhVien(new SinhVien().builder().maSV(currentCell.getStringCellValue()).build());
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                ketQuaHocTaps.add(ketQuaHocTap);
            }
            workbook.close();

            return ketQuaHocTaps;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}

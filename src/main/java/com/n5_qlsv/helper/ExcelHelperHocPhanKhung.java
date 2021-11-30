package com.n5_qlsv.helper;

import com.n5_qlsv.entity.HocPhan;
import com.n5_qlsv.entity.HocPhanKhung;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelperHocPhanKhung {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "HocPhanKhung";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<HocPhanKhung> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<HocPhanKhung> tutorials = new ArrayList<HocPhanKhung>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                HocPhanKhung hpk = new HocPhanKhung();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {

                        case 1:
                            hpk.setHocPhan(new HocPhan().builder().maHocPhan(currentCell.getStringCellValue()).build());
                            break;

                        case 2:
                            hpk.setSoTietLT((int) currentCell.getNumericCellValue());
                            break;

                        case 3:
                            hpk.setSoTietTH((int) currentCell.getNumericCellValue());
                            break;

                        case 4:
                            hpk.setThuTuHocKy((int) currentCell.getNumericCellValue());
                            break;

                        case 5:
                            hpk.setTrangThai(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                tutorials.add(hpk);
            }

            workbook.close();

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

}

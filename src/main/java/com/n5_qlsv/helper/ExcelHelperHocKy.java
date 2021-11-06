package com.n5_qlsv.helper;

import com.n5_qlsv.entity.*;
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

public class ExcelHelperHocKy {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Mô tả", "Năm bắt đầu", "Năm kết thúc", "Thứ tự học kì" };
    static String SHEET = "HocKi";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<HocKy> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<HocKy> tutorials = new ArrayList<HocKy>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                HocKy hocKy = new HocKy();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
//                        case 0:
//                            hocKy.setId((long) currentCell.getNumericCellValue());
//                            break;

                        case 1:
                            hocKy.setMoTa(currentCell.getStringCellValue());
                            break;

                        case 2:
                            hocKy.setNamBatDau((int) currentCell.getNumericCellValue());
                            break;

                        case 3:
                            hocKy.setNamKetThuc((int) currentCell.getNumericCellValue());
                            break;

                        case 4:
                            hocKy.setThuTuHocKy((int) currentCell.getNumericCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                tutorials.add(hocKy);
            }

            workbook.close();

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}

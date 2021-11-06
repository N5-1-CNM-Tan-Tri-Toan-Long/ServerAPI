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

public class ExcelHelperLopHocPhan {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "LopHocPhan";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<LopHocPhan> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<LopHocPhan> tutorials = new ArrayList<LopHocPhan>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                LopHocPhan lopHocPhan = new LopHocPhan();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
//                        case 0:
//                            hocKy.setId((long) currentCell.getNumericCellValue());
//                            break;

                        case 1:
                            lopHocPhan.setMoTa(currentCell.getStringCellValue());
                            break;

                        case 2:
                            lopHocPhan.setSoLuongDangKyHienTai((int) currentCell.getNumericCellValue());
                            break;

                        case 3:
                            lopHocPhan.setSoLuongDangKyToiDa((int) currentCell.getNumericCellValue());
                            break;

                        case 4:
                            lopHocPhan.setSoNhomTH((int) currentCell.getNumericCellValue());
                            break;

                        case 5:
                            lopHocPhan.setTenLHP(currentCell.getStringCellValue());
                            break;

                        case 6:
                            lopHocPhan.setTenVietTat(currentCell.getStringCellValue());
                            break;

                        case 7:
                            lopHocPhan.setTrangThai(currentCell.getStringCellValue());
                            break;

                        case 8:
                            lopHocPhan.setHocKy(new HocKy().builder().maHK((long) currentCell.getNumericCellValue()).build());
                            break;

                        case 9:
                            lopHocPhan.setHocPhan(new HocPhan().builder().maHocPhan(currentCell.getStringCellValue()).build());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                tutorials.add(lopHocPhan);
            }

            workbook.close();

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}

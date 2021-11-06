package com.n5_qlsv.helper;

import com.n5_qlsv.entity.ChuyenNganh;
import com.n5_qlsv.entity.HocPhan;
import com.n5_qlsv.entity.MonHoc;
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

public class ExcelHelperHocPhan {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "HocPhan";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<HocPhan> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<HocPhan> tutorials = new ArrayList<HocPhan>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                HocPhan hocPhan = new HocPhan();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
//                        case 0:
//                            hocKy.setId((long) currentCell.getNumericCellValue());
//                            break;

                        case 1:
                            hocPhan.setHocPhanBatBuoc(currentCell.getBooleanCellValue());
                            break;

                        case 2:
                            hocPhan.setSoTCLT((int) currentCell.getNumericCellValue());
                            break;

                        case 3:
                            hocPhan.setSoTCTH((int) currentCell.getNumericCellValue());
                            break;

                        case 4:
                            hocPhan.setChuyenNganh(new ChuyenNganh().builder().maChuyenNganh((long) currentCell.getNumericCellValue()).build());
                            break;

                        case 5:
                            hocPhan.setMonHoc(new MonHoc().builder().maMonHoc((long) currentCell.getNumericCellValue()).build());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                tutorials.add(hocPhan);
            }

            workbook.close();

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}

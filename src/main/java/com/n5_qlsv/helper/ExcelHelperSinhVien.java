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

public class ExcelHelperSinhVien {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Bậc đào tạo", "Địa chỉ", "Email", "Giới tính", "Ngày sinh"
            , "Ngày vào trường", "Password", "Role_name", "Số CMND", "Số điện thoại", "Tên sinh viên"
            , "Mã chuyên ngành", "Mã khoa", "Lớp học"};
    static String SHEET = "SinhVien";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<SinhVien> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<SinhVien> tutorials = new ArrayList<SinhVien>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                SinhVien sv = new SinhVien();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
//                        case 0:
//                            hocKy.setId((long) currentCell.getNumericCellValue());
//                            break;

                        case 1:
                            sv.setBacDaoTao(currentCell.getStringCellValue());
                            break;

                        case 2:
                            sv.setDiaChi(currentCell.getStringCellValue());
                            break;

                        case 3:
                            sv.setEmail(currentCell.getStringCellValue());
                            break;

                        case 4:
                            sv.setGioiTinh(currentCell.getBooleanCellValue());
                            break;

                        case 5:
                            sv.setNgaySinh(currentCell.getDateCellValue());
                            break;

                        case 6:
                            sv.setNgayVaoTruong(currentCell.getDateCellValue());
                            break;

                        case 7:
                            sv.setPassword(currentCell.getStringCellValue());
                            break;

                        case 8:
                            sv.setRoleName(currentCell.getStringCellValue());
                            break;

                        case 9:
                            sv.setSoCMND(currentCell.getStringCellValue());
                            break;

                        case 10:
                            sv.setSoDienThoai(currentCell.getStringCellValue());
                            break;

                        case 11:
                            sv.setTenSV(currentCell.getStringCellValue());
                            break;

                        case 12:
                            sv.setChuyenNganh(new ChuyenNganh().builder().maChuyenNganh((long) currentCell.getNumericCellValue()).build());
                            break;

                        case 13:
                            sv.setKhoa(new Khoa().builder().maKhoa((long) currentCell.getNumericCellValue()).build());
                            break;

                        case 14:
                            sv.setLopHoc(new LopHoc().builder().maLop((long) currentCell.getNumericCellValue()).build());

                        default:
                            break;
                    }

                    cellIdx++;
                }

                tutorials.add(sv);
            }

            workbook.close();

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

}

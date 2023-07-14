package Project_CSV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class p4 {

    public static void main(String[] args) {
        try {
            String file = "C:/Users/kopo/Desktop/수원fc관중통계(전체현황).xlsx";
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Sheet5");

            for (int row = 1; row < sheet.getPhysicalNumberOfRows(); row++) {
                XSSFRow rows = sheet.getRow(row);
                if (rows != null) {
                    String value = "";
                    int cells = rows.getPhysicalNumberOfCells();
                    for (int column = 0; column < cells; column++) {
                        XSSFCell cell = rows.getCell(column);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case NUMERIC:
                                    value = cell.getNumericCellValue() + "";
                                    break;
                                case STRING:
                                    value = cell.getStringCellValue() + "";
                                    break;
                                case BLANK:
                                    value = cell.getBooleanCellValue() + "";
                                    break;
                                case ERROR:
                                    value = cell.getErrorCellValue() + "";
                                    break;
                                default:
                                    break;
                            }
                            System.out.print(value + " ");
                        }
                    }
                }
                System.out.println();
            }
            
            workbook.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ExcelData.Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private ExcelUtils() {} // private constructor to prevent instantiation

    /**
     * Read a single cell from Excel
     * @param filePath full path of the Excel file
     * @param sheetName name of the sheet
     * @param rowIndex 0-based row index (header = row 0)
     * @param colIndex 0-based column index
     * @return cell value as String
     * @throws IOException if file not found or cannot read
     */
    public static String getCell(String filePath, String sheetName, int rowIndex, int colIndex) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            fis.close();
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            workbook.close();
            fis.close();
            throw new RuntimeException("Row not found: " + rowIndex);
        }

        DataFormatter formatter = new DataFormatter();  // Its job: convert any Excel cell into a readable String, no matter the type (text, number, date, formula, etc.).
        String value = formatter.formatCellValue(row.getCell(colIndex)).trim();

        workbook.close();
        fis.close();
        return value;
    }
}

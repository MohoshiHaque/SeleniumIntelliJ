package ExcelData.Demo;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    @Test

    public void ExcelReaderTest() throws IOException {

        String path= "C:\\Users\\USER\\IdeaProjects\\TestData\\LoginData.xlsx";

        // Load file
        // The class/type in Java FileInputStream
        // FileInputStream fis → declares a variable fis that can hold a file reader.
        // new FileInputStream("C:\\TestData\\LoginData.xlsx") → actually opens the Excel file and links it to fis.
        FileInputStream fis = new FileInputStream(path);

        // Workbook This is an Apache POI interface representing the entire Excel file (all sheets).
        // It reads the content from the FileInputStream fis.
        Workbook workbook = new XSSFWorkbook(fis);

        // Get sheet by name
        // Get the specific sheet (tab) from the Excel file so you can read its rows and cells.
        // Sheet represents all the rows and cells in that Excel tab.
        Sheet sheet = workbook.getSheet("Sheet1");

        // Loop through rows
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {

            //Get the specific row from the Excel sheet by its index.
            //Row represents all the cells in that row.
            //Row is a class in Apache POI that represents one horizontal line of cells in the Excel sheet.
            //row is a variable name you declare.
            Row row = sheet.getRow(i);

            // Get cell values
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            System.out.println("Username: " + username + " | Password: " + password);
        }

        // Close workbook
        workbook.close();
        fis.close();


    }


}

package utilities;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataGeneratorUtil {

    public static void main(String[] args) {
        String[] columns = {"id", "username", "firstName", "lastName", "email", "password", "phone", "userStatus"};
        int numberOfRows = 5; // Number of test data sets to generate
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss"));

        Faker faker = new Faker();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PostApiTestData");

        // Create Header Row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Generate Fake Data Rows
        for (int i = 1; i <= numberOfRows; i++) {
            Row row = sheet.createRow(i);

            // Columns as per your JSON screenshot
            row.createCell(0).setCellValue(String.valueOf(faker.number().randomNumber(5,true))); // id
            row.createCell(1).setCellValue(faker.name().username());                             // username
            row.createCell(2).setCellValue(faker.name().firstName());                            // firstName
            row.createCell(3).setCellValue(faker.name().lastName());                             // lastName
            row.createCell(4).setCellValue(faker.internet().emailAddress());                     // email
            row.createCell(5).setCellValue(faker.internet().password());                        // password
            row.createCell(6).setCellValue(faker.phoneNumber().cellPhone());                     // phone
            row.createCell(7).setCellValue(faker.number().randomDigit());                                                  // userStatus (Integer)
        }

        // Auto-size columns for better readability
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream("GeneratedTestData_"+timestamp+".xlsx")) {
            workbook.write(fileOut);
            System.out.println("✅ Success! Excel file 'PostApiTestData.xlsx' generated with "+numberOfRows+" rows.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
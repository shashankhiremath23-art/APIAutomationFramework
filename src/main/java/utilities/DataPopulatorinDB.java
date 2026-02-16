package utilities;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataPopulatorinDB {
    // Use the exact URL that worked in your TestDBConnection script
    private static final String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;"
            + "databaseName=FakerTest;"
            + "user=sa;"
            + "password=12345;" // The password from your successful test
            + "encrypt=true;trustServerCertificate=true;";

    public static void main(String[] args) {

        int numberOfRowsRequired = 300;

        Faker faker = new Faker();
        String sql = "INSERT INTO Users (FullName, Email, JobTitle, Company) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            System.out.println("Starting data insertion...");

            // Let's insert 50 fake users
            for (int i = 0; i < numberOfRowsRequired; i++) {

                pstmt.setString(1, faker.name().fullName());
                pstmt.setString(2, faker.internet().emailAddress());
                pstmt.setString(3, faker.job().title());
                pstmt.setString(4, faker.company().name());


                pstmt.addBatch(); // Batching makes it much faster
            }

            pstmt.executeBatch();
            System.out.println("✅ Success! "+numberOfRowsRequired+" dummy records inserted into 'Users' table.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
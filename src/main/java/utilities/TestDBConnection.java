package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    // Note the double backslash \\ for the instance name
    // Template: jdbc:sqlserver://[ServerName]\[InstanceName];databaseName=[YourDatabase]
    private static final String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;"
            + "databaseName=FakerTest;"
            + "user=sa;"
            + "password=12345;" // Use the password you set in step 1
            + "encrypt=true;trustServerCertificate=true;";

    public static void main(String[] args) {
        System.out.println("Testing connection to SQLEXPRESS...");

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("✅ SUCCESS: Connected to the database!");
            }
        } catch (SQLException e) {
            System.err.println("❌ CONNECTION FAILED!");
            System.err.println("Error Message: " + e.getMessage());
            System.err.println("Error Code: " + e.getErrorCode());

            if (e.getMessage().contains("TCP/IP")) {
                System.err.println("\nTIP: Ensure TCP/IP is enabled in SQL Server Configuration Manager.");
            }
        }
    }
}
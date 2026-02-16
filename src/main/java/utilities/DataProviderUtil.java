package utilities;

import config.ConfigManager;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Objects;

public class DataProviderUtil {

    @DataProvider(name = "petsData")
    public Object[][] getPetsData(Method method) {

        String filePath = Objects.requireNonNull(
                           getClass()
                                   .getClassLoader()
                                   .getResource(ConfigManager.get("testdataexcel.file")),
                                    "Excel file not found in resources!")
                                    .getPath();


        String sheetName = ConfigManager.get(method.getName()+".sheet");

        return ExcelUtil.getTestData(
                filePath,
                sheetName
        );

    }

    @DataProvider(name = "createUserData")
    public Object[][] getUserData(Method method) {
        // Fetching file path from your ConfigManager as seen in your existing code
        String filePath = Objects.requireNonNull(
                getClass().getClassLoader().getResource(ConfigManager.get("testdataexcel.file")),
                "Excel file not found in resources!"
        ).getPath();

        // You can use a specific sheet name like "PostApiTestData" seen in your excel file
        String sheetName = ConfigManager.get(method.getName()+".sheet");

        return ExcelUtil.getTestData(filePath, sheetName);
    }
}

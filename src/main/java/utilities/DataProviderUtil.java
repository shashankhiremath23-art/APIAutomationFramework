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



        //String path = getClass().getClassLoader().getResource(ConfigManager.get("testdata.path")).getPath();
       /* return ExcelUtil.getTestData(
                ConfigManager.get("testDataExcel.path"),
                "GetPetsAPI"
        );

        */
    }
}

package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reporting.ExtentTestManager;

public class LoggerUtil {

    private static final Logger log = LogManager.getLogger(LoggerUtil.class);

    public static void info(String message) {
        log.info(message);
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info(message);
        }
    }

    @SuppressWarnings("unused")
    public static void error(String message) {
        log.error(message);
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().fail(message);
        }
    }
}

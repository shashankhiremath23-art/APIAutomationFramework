package config;

public class EnvManager {


    public static String getBaseUrl() {
        String env = System.getProperty("env", "dev");


        return switch (env) {
            case "sit" -> "https://sit-bank-api.com";
            case "uat" -> "https://uat-bank-api.com";
            default -> "https://dev-bank-api.com";
        };
    }
}

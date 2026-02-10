package config;

public class EnvManager {


    public static String getBaseUrl() {
        String env = System.getProperty("env", "dev");


        switch (env) {
            case "sit": return "https://sit-bank-api.com";
            case "uat": return "https://uat-bank-api.com";
            default: return "https://dev-bank-api.com";
        }
    }
}

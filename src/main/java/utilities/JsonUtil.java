package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonUtil {

    public static <T> T readJson(String path, Class<T> clazz) throws Exception {
        return new ObjectMapper().readValue(new File(path), clazz);
    }
}

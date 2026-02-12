package utilities;

import io.restassured.response.Response;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class SchemaValidatorUtil {

        public static void validate(Response response, String schemaPath) {
            response.then().assertThat()
                    .body(matchesJsonSchema(new File(schemaPath)));
        }
    }



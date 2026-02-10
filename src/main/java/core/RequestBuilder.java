package core;

import io.restassured.response.Response;

public class RequestBuilder extends BaseAPI {

    public RequestBuilder addHeader(String key, String value) {
        request.header(key, value);
        return this;
    }

    public RequestBuilder addBody(Object body) {
        request.body(body);
        return this;
    }

    public Response post(String endpoint) {
        return request.post(endpoint);
    }

    public Response get(String endpoint) {
        return request.get(endpoint);
    }
}

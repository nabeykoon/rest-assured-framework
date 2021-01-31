package com.student.requests;

import com.student.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestClient extends TestBase {

    /**
     *
     * @param requestPath
     * @return
     */
    public Response doGetRequest(String requestPath) {
        Response response = RestAssured.given ()
                .when ()
                .get (requestPath);
        return response;
    }

    /**
     *
     * @param uri
     * @param body
     * @return
     */
    public Response doPostRequest(String uri, Object body){
        Response response = RestAssured.given ()
                .contentType (ContentType.JSON)
                .when ()
                .body (body)
                .post (uri);
        return response;
    }

    /**
     *
     * @param requestPath
     * @param params
     * @return
     */
    public Response doGetRequestWithQueryParam(String requestPath, Map<String, String> params){
        Response response = RestAssured.given ()
                .queryParams (params)
                .when ()
                .get (requestPath);
        return response;
    }

    /**
     *
     * @param requestPath
     * @param headers
     * @return
     */
    public Response doGetRequestWithHeader(String requestPath, Map<String, String> headers){
        Response response = RestAssured.given ()
                .headers (headers)
                .when ()
                .get (requestPath);
        return response;
    }

    /**
     *
     * @param requestPath
     * @param body
     * @return
     */
    public Response doPutRequest(String requestPath, Object body){
        Response response = RestAssured.given ()
                .when ()
                .body (body)
                .put (requestPath);
        return response;
    }

    /**
     *
     * @param requestPath
     * @param body
     * @return
     */
    public Response doPatchRequest(String requestPath, Object body){
        Response response = RestAssured.given ()
                .when ()
                .body (body)
                .patch (requestPath);
        return response;
    }

    /**
     *
     * @param requestPath
     * @return
     */
    public Response doDeleteRequest(String requestPath){
        Response response = RestAssured.given ()
                .when ()
                .delete (requestPath);
        return response;
    }

}

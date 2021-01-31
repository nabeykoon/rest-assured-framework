package com.student.tests;

import com.student.util.PropertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public static PropertyReader prop;
    @BeforeClass
    public void initUrl(){

        prop = PropertyReader.getInstance ();
        RestAssured.baseURI = prop.getProperty ("baseUrl");
        RestAssured.port = Integer.valueOf (prop.getProperty ("port"));
    }
}

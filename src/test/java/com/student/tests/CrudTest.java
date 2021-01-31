package com.student.tests;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CrudTest extends TestBase {

    RequestFactory requests = new RequestFactory ();

    @Story("This is CRUD testing story")
    @Feature("This is to test to get all students from database")
    @Test(groups = {"smoke", "fullRegression"})
    public void getAllStudent() {

        requests.getAllStudents ()
                .then ()
                .spec (SpecificationFactory.getGenericResponseSpec ())
                .statusCode (200)
                .log ()
                .all ();
    }

    @Story("This is CRUD testing story")
    @Feature("This is to create & verify a new student")
    @Test
    public void createNewStudent() {

        Faker fakeData = new Faker ();

        String firstName = fakeData.name ().firstName ();
        String lastName = fakeData.name ().lastName ();
        String email = fakeData.internet ().emailAddress ();
        String programme = "ComputerScience";
        List<String> courses = new ArrayList<String> ();
        courses.add ("C++");
        courses.add ("Java");
        requests.createNewStudent ("", firstName, lastName, email, programme, courses)
                .then ()
                .spec (SpecificationFactory.getGenericResponseSpec ())
                .statusCode (201);
    }
}

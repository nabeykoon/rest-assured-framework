package com.student.requests;

        import com.student.pojo.StudentPojo;
        import com.student.tests.TestBase;
        import io.qameta.allure.Step;
        import io.restassured.RestAssured;
        import io.restassured.response.Response;

        import java.util.List;

public class RequestFactory extends TestBase {

    RestClient restClient = new RestClient ();

    @Step("Getting all the student information from the DB")
    public Response getAllStudents() {
        Response response = restClient.doGetRequest ("/list");
        return response;
    }

    @Step("Creating a new student: {1}, {2}, {3}, {4}, {5}")
    public Response createNewStudent(String url, String firstName, String lastName, String email, String programme, List<String> courses){

        StudentPojo body = new StudentPojo ();
        body.setFirstName (firstName);
        body.setLastName (lastName);
        body.setEmail (email);
        body.setProgramme (programme);
        body.setCourses (courses);
        Response response = restClient.doPostRequest (url, body);
        return response;
    }

    @Step("Updating student information with student Id: {0}, firstName: {1}, lastName: {2}, email: {3}, programme: {4}, courses: {5}")
    public Response updateStudent(int studentId, String firstName, String lastName, String email, String programme, List<String> courses){

        StudentPojo body = new StudentPojo ();
        body.setFirstName (firstName);
        body.setLastName (lastName);
        body.setEmail (email);
        body.setProgramme (programme);
        body.setCourses (courses);
        Response response = restClient.doPutRequest ("/" + studentId, body);
        return response;
    }

    @Step("Deleting a student with Id: {0}")
    public Response deleteStudent(int studentId){
        Response response = restClient.doDeleteRequest ("/" + studentId);
        return response;
    }

    @Step("Getting a student with Id: {0}")
    public Response getStudentById(int studentId){
        Response response = restClient.doGetRequest ("/" + studentId);
        return response;
    }
}

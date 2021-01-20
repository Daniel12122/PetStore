package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.api.controller.ControllerPet;

import static utils.api.Constants.BASE_URL;

public class BaseTest {

    public static RequestSpecification requestSpecification;
    public ControllerPet petsController;

    @BeforeClass
    public void beforeClass() {
        petsController = new ControllerPet();
    }

    @BeforeSuite
    public void beforeSuite() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BASE_URL);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
    }

}

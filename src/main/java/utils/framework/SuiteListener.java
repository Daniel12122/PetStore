package utils.framework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import static utils.api.Constants.BASE_URL;

public class SuiteListener implements ISuiteListener {
    public static RequestSpecification requestSpecification;
    @Override
    public void onStart(ISuite iSuite) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BASE_URL);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();

    }

    @Override
    public void onFinish(ISuite iSuite) {

    }
}
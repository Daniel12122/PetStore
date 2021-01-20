package utils.api.controller;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import pojo.store.Order;
import pojo.store.OrderStatus;

import java.util.List;

import static base.BaseTest.requestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static utils.api.Constants.STORE_ENDPOINT;

public class ControllerOrder {

    public ValidatableResponse addNewOrder(Order order) {
        return given(requestSpecification)
                .body(order)
                .post(STORE_ENDPOINT)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void deleteOrder(Order order) {
        given(requestSpecification)
                .pathParam("Id", order.getId())
                .delete(STORE_ENDPOINT + "/{Id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void verifyOrderDeleted(Order order) {
        given(requestSpecification)
                .pathParam("orderId", order.getId())
                .get(STORE_ENDPOINT + "/{orderId}")
                .then()
                .body(containsString("Order not found"))
                .statusCode(404)
                .contentType(ContentType.JSON);
    }

    public Order getPet(Order order) {
        return given(requestSpecification)
                .pathParam("orderId", order.getId())
                .get(STORE_ENDPOINT + "/{orderId}").as(Order.class);
    }

    public List<Order> getPetsInventoryByStatus(OrderStatus status) {
        return given(requestSpecification)
                .queryParam("status", status.toString())
                .get(STORE_ENDPOINT + "/inventory")
                .then().log().all()
                .extract().body()
                .jsonPath().getList("", Order.class);

    }
}

package utils.api.controller;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pojo.pet.Pet;
import pojo.pet.PetStatus;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static utils.api.Constants.PET_ENDPOINT;
import static utils.framework.SuiteListener.requestSpecification;

public class ControllerPet {

    public ValidatableResponse addNewPet(Pet pet) {
        return given(requestSpecification)
                .body(pet)
                .post(PET_ENDPOINT)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public List<Pet> getPetsByStatus(PetStatus status) {
        return given(requestSpecification)
                .queryParam("status", status.toString())
                .get(PET_ENDPOINT + "/findByStatus")
                .then().log().all()
                .extract().body()
                .jsonPath().getList("", Pet.class);

    }

    public void deletePet(Pet pet) {
        given(requestSpecification)
                .pathParam("Id", pet.getId())
                .delete(PET_ENDPOINT + "/{Id}");
    }

    public void verifyPetDeleted(Pet pet) {
        given(requestSpecification)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}")
                .then()
                .body(containsString("Pet not found"));
    }

    public String getPet(Pet pet) {
        return given(requestSpecification)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}").asString();
    }

    public Pet updatePet(Pet pet) {
        return given(requestSpecification)
                .body(pet)
                .put(PET_ENDPOINT).as(Pet.class);
    }

}
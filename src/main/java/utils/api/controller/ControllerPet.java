package utils.api.controller;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import pojo.pet.Pet;
import pojo.pet.PetStatus;

import java.util.List;

import static base.BaseTest.requestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static utils.api.Constants.PET_ENDPOINT;

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
                .delete(PET_ENDPOINT + "/{Id}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void verifyPetDeleted(Pet pet) {
        given(requestSpecification)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}")
                .then()
                .body(containsString("Pet not found"))
                .statusCode(404)
                .contentType(ContentType.JSON);
    }

    public ValidatableResponse getPet(Pet pet) {
        return given(requestSpecification)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}")
                .then()
                .contentType(ContentType.JSON);
    }

    public Pet updatePet(Pet pet) {
        return given(requestSpecification)
                .body(pet)
                .put(PET_ENDPOINT).as(Pet.class);
    }

}
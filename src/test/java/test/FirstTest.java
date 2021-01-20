package test;


import base.BaseTest;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import pojo.pet.Pet;
import utils.api.controller.ControllerPet;
import utils.data.builder.BuilderPet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;


public class FirstTest extends BaseTest {

    ControllerPet petsController;
    Pet pet = BuilderPet.defaultPet();

    @Test(priority = 0)
    public void addNewPet() {
        String petResponse = petsController.addNewPet(pet).toString();
        System.out.println(petResponse);
    }

    @Test(priority = 1)
    public void verifyNewPet() {
        petsController.getPet(pet);
    }

    @Test(priority = 2)
    public void updatePet() {
        pet.setName("New name for my pet");
        Pet petResponse = petsController.updatePet(pet);
        assertThat(petResponse, is(samePropertyValuesAs(pet)));
    }

    @Test(priority = 3)
    public void verifyUpdatedPet() {
        ValidatableResponse petResponse = petsController.getPet(pet);
        System.out.println(petResponse);
    }

    @Test(priority = 4)
    public void deletePetAndDoCheck() {
        petsController.deletePet(pet);
        petsController.verifyPetDeleted(pet);
    }
}
package test;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.pet.Pet;
import utils.api.controller.ControllerPet;
import utils.data.builder.BuilderPet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;


public class First {

    ControllerPet petsController;
    Pet pet = BuilderPet.defaultPet();

    @BeforeClass
    public void beforeClass() {
        petsController = new ControllerPet();
    }

    @Test(priority = 0)
    public void addNewPet() {
        String petResponse = petsController.addNewPet(pet).toString();
        System.out.println(petResponse);
    }

    @Test(priority = 1)
    public void verifyNewPet() {
        String petResponse = petsController.getPet(pet);
        System.out.println(petResponse);
    }

    @Test(priority = 2)
    public void updatePet() {
        pet.setName("New name for my pet");
        Pet petResponse = petsController.updatePet(pet);
        assertThat(petResponse, is(samePropertyValuesAs(pet)));
    }

    @Test(priority = 3)
    public void verifyUpdatedPet() {
        String petResponse = petsController.getPet(pet);
        System.out.println(petResponse);;
    }

    @Test(priority = 4)
    public void deletePetAndDoCheck() {
        petsController.deletePet(pet);
        petsController.verifyPetDeleted(pet);
    }
}
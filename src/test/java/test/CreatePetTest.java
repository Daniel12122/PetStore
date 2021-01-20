package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pojo.pet.Pet;
import utils.data.builder.BuilderPet;

public class CreatePetTest extends BaseTest {

    Pet defaultPet = BuilderPet.defaultPet();
    Pet randomPet = BuilderPet.randomPet();
    Pet noParameterPet = new Pet();
    Pet petZeroID = BuilderPet.zeroIDPet();
    Pet negativeNumberIDPet = BuilderPet.negativeNumberIDPet();
    Pet onlyIDPet = BuilderPet.onlyIDPet();
    Pet withoutIDPet = BuilderPet.withoutIDPet();
    Pet maxIntegerIDPet = BuilderPet.maxIntegerIDPet();


    @Test
    public void addDefaultPetTest() {
        petsController.addNewPet(defaultPet).statusCode(200);
        petsController.getPet(defaultPet).statusCode(200);
    }

    @Test
    public void addRandomPetTest() {
        petsController.addNewPet(randomPet).statusCode(200);
        petsController.getPet(randomPet).statusCode(200);
    }

    @Test
    public void addNoParameterPetTest() {
        petsController.addNewPet(noParameterPet).statusCode(200);
        petsController.getPet(noParameterPet).statusCode(404);
    }

    @Test
    public void addZeroIDPetTest() {
        petsController.addNewPet(petZeroID).statusCode(200);
        petsController.getPet(petZeroID).statusCode(404);
    }

    @Test
    public void addNegativeNumberIDPetTest() {
        petsController.addNewPet(negativeNumberIDPet).statusCode(200);
        petsController.getPet(negativeNumberIDPet).statusCode(404);
    }

    @Test
    public void addOnlyIDPetTest() {
        petsController.addNewPet(onlyIDPet).statusCode(200);
        petsController.getPet(onlyIDPet).statusCode(200);
    }

    @Test
    public void addWithoutIDPetTest() {
        petsController.addNewPet(withoutIDPet).statusCode(200);
        petsController.getPet(withoutIDPet).statusCode(404);
    }

    @Test
    public void addMaxIntegerIDPetTest() {
        petsController.addNewPet(maxIntegerIDPet).statusCode(200);
        petsController.getPet(maxIntegerIDPet).statusCode(200);
    }
}

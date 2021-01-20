package utils.data.builder;

import com.github.javafaker.Faker;
import pojo.pet.Category;
import pojo.pet.Pet;
import pojo.pet.PetStatus;
import pojo.pet.Tag;

import java.util.Collections;

public class BuilderPet {
    public static Pet defaultPet() {
        return Pet.builder().id(948138489)
                .category(new Category(1, "dogs"))
                .name("My pet")
                .tags(Collections.singletonList(new Tag(1, "golden-retriever")))
                .status(PetStatus.available)
                .build();
    }

    public static  Pet randomPet() {
        Faker faker = new Faker();
        return Pet.builder()
                .id(faker.number().randomDigitNotZero())
                .category(new Category(faker.number().numberBetween(1, 999), faker.name().firstName()))
                .name(faker.name().username())
                .tags(Collections.singletonList(new Tag(faker.number().numberBetween(1, 999), faker.name().firstName())))
                .status(PetStatus.randomStatus())
                .build();
    }

    public static Pet zeroIDPet() {
        return Pet.builder().id(0)
                .category(new Category(1, "dogs"))
                .name("My pet")
                .tags(Collections.singletonList(new Tag(1, "golden-retriever")))
                .status(PetStatus.available)
                .build();
    }

    public static Pet negativeNumberIDPet() {
        return Pet.builder().id(-45)
                .category(new Category(1, "dogs"))
                .name("My pet")
                .tags(Collections.singletonList(new Tag(1, "golden-retriever")))
                .status(PetStatus.available)
                .build();
    }

    public static Pet onlyIDPet() {
        return Pet.builder().id(4889)
                .build();
    }

    public static Pet withoutIDPet() {
        return Pet.builder()
                .category(new Category(1, "dogs"))
                .name("My pet")
                .tags(Collections.singletonList(new Tag(1, "golden-retriever")))
                .status(PetStatus.available)
                .build();
    }

    public static Pet maxIntegerIDPet() {
        return Pet.builder().id(2147483647)
                .build();
    }
}
package utils.data.builder;

import com.github.javafaker.Faker;
import pojo.pet.Pet;
import pojo.store.Order;
import pojo.store.OrderStatus;



public class BuilderOrder {

    public static Order defaultOrder(Pet pet) {
        return Order.builder()
                .id(32564548)
                .petId(pet.getId())
                .quantity(31556)
                .shipDate("2021-01-17T17:23:38.226Z")
                .status(OrderStatus.approved)
                .complete(true)
                .build();
    }

    public static  Order randomOrder(Pet pet) {
        Faker faker = new Faker();
        return Order.builder()
                .id(faker.number().randomDigitNotZero())
                .petId(pet.getId())
                .quantity(faker.number().randomDigitNotZero())
                .shipDate(faker.date().birthday().toString())
                .status(OrderStatus.randomStatus())
                .complete(true)
                .build();
    }
}
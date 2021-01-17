package utils.data.builder;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import pojo.user.User;

public  class BuilderUser {
    public static User defaultUser() {
        return User.builder()
                .id(12345)
                .username("Danya Pazykov")
                .firstName("Danya")
                .lastName("Pazykov")
                .email("pazykovd@gmail.com")
                .password("5k3zkl43")
                .phone("+380508310619")
                .userStatus(3)
                .build();
    }
    public static  User randomUser() {
        Faker faker = new Faker();
        return  User.builder()
                .id(faker.number().randomDigitNotZero())
                .username(faker.name().username())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(RandomStringUtils.randomAlphabetic(10) + "@gmail.com")
                .password(RandomStringUtils.randomAlphanumeric(8))
                .phone(faker.phoneNumber().phoneNumber())
                .userStatus(faker.number().randomDigit())
                .build();
    }
}
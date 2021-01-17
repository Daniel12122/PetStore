package pojo.pet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum PetStatus {
    available("available"),
    pending("pending"),
    sold("sold");

    private String value;

    PetStatus(String value) {
        this.value = value;
    }

    private static final List<PetStatus> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static PetStatus randomStatus() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
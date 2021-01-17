package pojo.store;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum OrderStatus {
    placed("placed"),
    approved("approved"),
    delivered ("delivered ");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    private static final List<OrderStatus> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static OrderStatus randomStatus() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
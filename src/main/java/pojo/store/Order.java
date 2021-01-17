package pojo.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private OrderStatus status;
    private  boolean complete;
}
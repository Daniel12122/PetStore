package pojo.pet;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls = new ArrayList<>();
    private List<Tag> tags = new ArrayList<>();
    private PetStatus status;

}
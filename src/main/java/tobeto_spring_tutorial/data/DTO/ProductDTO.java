package tobeto_spring_tutorial.data.DTO;

import lombok.Builder;

@Builder
public record ProductDTO(int id, String name, double price, CategoryDTO categoryDTO) {

}

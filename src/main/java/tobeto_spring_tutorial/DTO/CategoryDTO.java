package tobeto_spring_tutorial.DTO;

import lombok.Builder;

@Builder
public record CategoryDTO(int id,
                          String name) {
}

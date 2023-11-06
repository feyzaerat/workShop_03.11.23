package tobeto_spring_tutorial.data.DTO.DtoForAdmin;

import lombok.Builder;

@Builder
public record AdminCategoryDTO(int id,
                               String name) {
}

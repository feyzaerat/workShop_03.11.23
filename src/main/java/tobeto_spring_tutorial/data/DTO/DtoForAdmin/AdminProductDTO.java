package tobeto_spring_tutorial.data.DTO.DtoForAdmin;

import lombok.Builder;

@Builder
public record AdminProductDTO(int id, String name, double price) {
}

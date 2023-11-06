package tobeto_spring_tutorial.data.DTO.DtoForAdmin;

import lombok.Builder;

@Builder
public record AdminEmployerDTO(int id, String name, String emailAddress, String shippingAddress, String password) {
}

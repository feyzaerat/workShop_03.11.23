package tobeto_spring_tutorial.data.DTO;

import lombok.Builder;

@Builder
public record EmployerDTO(int id, String name, String emailAddress, String shippingAddress) {
}

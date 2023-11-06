package tobeto_spring_tutorial.data.DTO.DtoForAdmin;

import lombok.Builder;

@Builder
public record AdminEmployeeDTO(int id, String name, String emailAddress, double salary, String password) {
}

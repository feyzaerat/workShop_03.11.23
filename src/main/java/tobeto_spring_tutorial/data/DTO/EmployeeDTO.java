package tobeto_spring_tutorial.data.DTO;

import lombok.Builder;

@Builder
public record EmployeeDTO(int id, String name, String emailAddress, double salary) {
}

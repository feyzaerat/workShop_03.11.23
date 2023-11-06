package tobeto_spring_tutorial.data.DTO.responses;

import lombok.Builder;

@Builder
public record TCResponse<T>(String message, T response, boolean isSuccess) {
}

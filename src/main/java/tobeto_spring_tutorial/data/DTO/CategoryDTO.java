package tobeto_spring_tutorial.data.DTO;

import lombok.Builder;

@Builder
public record CategoryDTO(int id,
                          String name, boolean isDeleted) {
}
//isdelete eklendi deneme için. softdelete için.
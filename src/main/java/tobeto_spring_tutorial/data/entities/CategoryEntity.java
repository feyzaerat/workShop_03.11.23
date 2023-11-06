package tobeto_spring_tutorial.data.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_spring_tutorial.data.DTO.CategoryDTO;
import tobeto_spring_tutorial.data.entities.baseEntites.BaseEntity;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;


    public CategoryDTO convertToDTO(){
        return CategoryDTO.builder()
                .id(this.id)
                .name(this.name)
                .isDeleted(getIsDeleted())
                .build();
    }

}

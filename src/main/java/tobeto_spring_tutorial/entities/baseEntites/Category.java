package tobeto_spring_tutorial.entities.baseEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_spring_tutorial.DTO.CategoryDTO;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;

    public CategoryDTO convertToDTO(){
        return CategoryDTO.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }

}

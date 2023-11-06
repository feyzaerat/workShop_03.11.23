package tobeto_spring_tutorial.data.entities.baseEntites;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_spring_tutorial.data.DTO.ProductDTO;
import tobeto_spring_tutorial.data.entities.CategoryEntity;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
public class ProductEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_entity")
    private CategoryEntity categoryEntity;

    public ProductDTO convertToDTO() {
        return ProductDTO.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .categoryDTO(this.categoryEntity.convertToDTO())
                .build();
    }

    @Override
    public String toString() {
        return
                "id= " + id + "\n" +
                        "name= " + name + '\n' +
                        "price= " + price + "\n\n";
    }
}

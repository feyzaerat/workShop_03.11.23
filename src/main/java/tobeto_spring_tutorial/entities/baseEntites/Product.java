package tobeto_spring_tutorial.entities.baseEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private int id;
    private String name;
    private double price;

    @Override
    public String toString() {
        return
                "id= " + id + "\n" +
                "name= " + name + '\n' +
                "price= " + price  + "\n\n";
    }
}

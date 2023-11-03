package tobeto_spring_tutorial.entities.baseEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String emailAddress;

    @Override
    public String toString() {
        return
                "id= " + id + '\n' +
                "name= " + name + '\n' +
                "emailAddress= " + emailAddress + "\n\n";
    }
}

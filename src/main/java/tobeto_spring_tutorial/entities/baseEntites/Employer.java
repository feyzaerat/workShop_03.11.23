package tobeto_spring_tutorial.entities.baseEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

package tobeto_spring_tutorial.data.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_spring_tutorial.data.DTO.DtoForAdmin.AdminEmployerDTO;
import tobeto_spring_tutorial.data.DTO.EmployerDTO;
import tobeto_spring_tutorial.data.entities.baseEntites.UserEntity;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "employers")
public class EmployerEntity extends UserEntity {

    @Column(name = "shipping_address")
    private String shippingAddress;

    public EmployerDTO convertToDto(){
        return EmployerDTO.builder()
                .id(getId()) //getId yazmamızın sebebi UserEntity klasını extend etmemiz
                .name(getName())
                .emailAddress(getEmailAddress())
                .shippingAddress(shippingAddress)
                .build();
    }

    public AdminEmployerDTO convertToAdminDto(){
        return AdminEmployerDTO.builder()
                .id(getId())
                .name(getName())
                .emailAddress(getEmailAddress())
                .shippingAddress(shippingAddress)
                .build();
    }

//    @Override
//    public String toString() {
//        return
//                "id= " + id + '\n' +
//                "name= " + name + '\n' +
//                "emailAddress= " + emailAddress + "\n\n";
//    }
}

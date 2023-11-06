package tobeto_spring_tutorial.data.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_spring_tutorial.data.DTO.DtoForAdmin.AdminEmployeeDTO;
import tobeto_spring_tutorial.data.DTO.EmployeeDTO;
import tobeto_spring_tutorial.data.entities.baseEntites.UserEntity;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "employees")
public class EmployeeEntity extends UserEntity {

        @Column(name = "salary")
        private double salary;

        public EmployeeDTO convertToDto(){
                return EmployeeDTO.builder()
                        .id(getId()) //getId yazmamızın sebebi UserEntity klasını extend etmemiz
                        .name(getName())
                        .emailAddress(getEmailAddress())
                        .salary(this.salary)
                        .build();
        }

        public AdminEmployeeDTO convertToAdminDto(){
                return AdminEmployeeDTO.builder()
                        .id(getId())
                        .name(getName())
                        .emailAddress(getEmailAddress())
                        .salary(this.salary)
                        .password(getPassword())
                        .build();
        }
//    @Override
//    public String toString() {
//        return
//                "id=" + id + '\n' +
//                        "name=" + name + '\n' +
//                        "emailAddress=" + emailAddress + "\n\n";
//    }


}

package tobeto_spring_tutorial.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_spring_tutorial.data.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
}

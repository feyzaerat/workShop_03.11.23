package tobeto_spring_tutorial.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_spring_tutorial.data.entities.EmployerEntity;

public interface EmployerRepository extends JpaRepository<EmployerEntity,Integer> {
}

package tobeto_spring_tutorial.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_spring_tutorial.data.entities.baseEntites.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}

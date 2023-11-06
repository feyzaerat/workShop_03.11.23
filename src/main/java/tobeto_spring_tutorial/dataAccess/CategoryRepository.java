package tobeto_spring_tutorial.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_spring_tutorial.data.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}

package tobeto_spring_tutorial.business.entityServices.abstracts;

import tobeto_spring_tutorial.data.entities.CategoryEntity;

import java.util.List;

public interface CategoryEntityService {

    CategoryEntity save(CategoryEntity categoryEntity);

    CategoryEntity getById(int id);

    List<CategoryEntity> getAllEntities();

    CategoryEntity update(CategoryEntity categoryEntity);

    void delete(CategoryEntity categoryEntity);
}

package tobeto_spring_tutorial.business.entityServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.business.entityServices.abstracts.CategoryEntityService;
import tobeto_spring_tutorial.data.entities.CategoryEntity;
import tobeto_spring_tutorial.dataAccess.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryEntityManager implements CategoryEntityService {
    private final CategoryRepository categoryRepository;
    //TODO hepsi yazıldı.
    @Override
    public CategoryEntity save(CategoryEntity categoryEntity) {

        return this.categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity getById(int id) {
        return this.categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<CategoryEntity> getAllEntities() {
        return this.categoryRepository.findAll();
    }

    @Override
    public CategoryEntity update(CategoryEntity categoryEntity) {
        return this.categoryRepository.save(categoryEntity);
    }

    @Override
    public void delete(CategoryEntity categoryEntity) {
        this.categoryRepository.delete(categoryEntity);
    }
}

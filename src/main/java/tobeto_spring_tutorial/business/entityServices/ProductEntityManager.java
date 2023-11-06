package tobeto_spring_tutorial.business.entityServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.business.entityServices.abstracts.ProductEntityService;
import tobeto_spring_tutorial.data.entities.baseEntites.ProductEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductEntityManager implements ProductEntityService {
    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return null;
    }

    @Override
    public ProductEntity getById(int id) {
        return null;
    }

    @Override
    public List<ProductEntity> getAllEntities() {
        return null;
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
        return null;
    }

    @Override
    public void delete(ProductEntity productEntity) {

    }
}

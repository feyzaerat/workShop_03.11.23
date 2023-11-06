package tobeto_spring_tutorial.business.entityServices.abstracts;

import tobeto_spring_tutorial.data.entities.baseEntites.ProductEntity;

import java.util.List;

public interface ProductEntityService {
    ProductEntity save(ProductEntity productEntity);

    ProductEntity getById(int id);

    List<ProductEntity> getAllEntities();

    ProductEntity update(ProductEntity productEntity);

    void delete(ProductEntity productEntity);
}

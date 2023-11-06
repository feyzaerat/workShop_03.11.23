package tobeto_spring_tutorial.business.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.business.services.abstracts.ProductService;
import tobeto_spring_tutorial.data.entities.baseEntites.ProductEntity;
import tobeto_spring_tutorial.data.requests.Product.AddProductReq;
import tobeto_spring_tutorial.data.requests.Product.DeleteProductReq;
import tobeto_spring_tutorial.data.requests.Product.GetProductReq;
import tobeto_spring_tutorial.data.requests.Product.UpdateProductReq;
import tobeto_spring_tutorial.dataAccess.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private CategoryManager categoryManager;
    private List<ProductEntity> productEntities = new ArrayList<ProductEntity>();

    private int lastId;

    @Override
    public String add(AddProductReq addProductReq) {
        ProductEntity productEntity = new ProductEntity();

        ProductEntity.builder()
                        .name(addProductReq.name())
                                .price(addProductReq.price())
                                        .categoryEntity(categoryManager.findById(addProductReq.categoryId()));

        idSetter();
        productEntity.setId(lastId);
        productEntity.setName(addProductReq.name());
        productEntity.setPrice(addProductReq.price());
        productEntity.setCategoryEntity(categoryManager.findById(addProductReq.categoryId()));

        productEntities.add(productEntity);
        return "Ürün eklendi: " + productEntity.getName();
    }

    @Override
    public String get(GetProductReq getProductReq) throws Exception {
        ProductEntity productEntity = this.findById(getProductReq.id());

        if (productEntity != null) {
            return productEntity.toString();
        }
        throw new Exception("Böyle bir ürün yok");
    }

    @Override
    public String getAll() {
        if (productEntities.isEmpty()) {
            throw new RuntimeException("Liste boş");
        }

        return productEntities.toString();
    }

    @Override
    public String delete(DeleteProductReq deleteProductReq) throws Exception {
        if (productEntities.removeIf(productEntity -> productEntity.getId() == deleteProductReq.id())) {
            return "Ürün silindi";
        }

        throw new Exception("Böyle bir ürün yok");
    }

    @Override
    public String update(UpdateProductReq updateProductReq) {
        ProductEntity productEntity = this.findById(updateProductReq.id());
        String deletedName = productEntity.getName();

        productEntity.setName(updateProductReq.newName());
        return "Ürün güncellendi : " + deletedName + " -> "+ productEntity.getName();
    }

    public ProductEntity findById(int id) {
        if (productEntities.isEmpty()) {
            return null;
        }

        for (ProductEntity productEntity : productEntities) {

            if (productEntity.getId() == id) {
                return productEntity;
            }
        }
        return null;
    }

    public void idSetter() {
        if (productEntities.toArray().length > 0) {
            lastId++;
        }
    }
}

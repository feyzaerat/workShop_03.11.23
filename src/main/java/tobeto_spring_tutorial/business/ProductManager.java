package tobeto_spring_tutorial.business;

import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.entities.baseEntites.Product;
import tobeto_spring_tutorial.requests.Product.AddProductReq;
import tobeto_spring_tutorial.requests.Product.DeleteProductReq;
import tobeto_spring_tutorial.requests.Product.GetProductReq;
import tobeto_spring_tutorial.requests.Product.UpdateProductReq;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager implements tobeto_spring_tutorial.business.abstracts.ProductService {

    private List<Product> products = new ArrayList<Product>();

    private int lastId;

    @Override
    public String add(AddProductReq addProductReq) {
        Product product = new Product();
        idSetter();
        product.setId(lastId);
        product.setName(addProductReq.name());
        product.setPrice(addProductReq.price());

        products.add(product);
        return "Ürün eklendi: " + product.getName();
    }

    @Override
    public String get(GetProductReq getProductReq) throws Exception {
        Product product = this.findById(getProductReq.id());

        if (product != null) {
            return product.toString();
        }
        throw new Exception("Böyle bir ürün yok");
    }

    @Override
    public String getAll() {
        if (products.isEmpty()) {
            throw new RuntimeException("Liste boş");
        }

        return products.toString();
    }

    @Override
    public String delete(DeleteProductReq deleteProductReq) throws Exception {
        if (products.removeIf(product -> product.getId() == deleteProductReq.id())) {
            return "Ürün silindi";
        }

        throw new Exception("Böyle bir ürün yok");
    }

    @Override
    public String update(UpdateProductReq updateProductReq) {
        Product product = this.findById(updateProductReq.id());
        String deletedName = product.getName();

        product.setName(updateProductReq.newName());
        return "Ürün güncellendi : " + deletedName + " -> "+ product.getName();
    }

    public Product findById(int id) {
        if (products.isEmpty()) {
            return null;
        }

        for (Product product : products) {

            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void idSetter() {
        if (products.toArray().length > 0) {
            lastId++;
        }
    }
}

package tobeto_spring_tutorial.business.abstracts;

import tobeto_spring_tutorial.requests.Product.AddProductReq;
import tobeto_spring_tutorial.requests.Product.DeleteProductReq;
import tobeto_spring_tutorial.requests.Product.GetProductReq;
import tobeto_spring_tutorial.requests.Product.UpdateProductReq;

public interface ProductService {
    String add(AddProductReq addProductReq);

    String get(GetProductReq getProductReq) throws Exception;
    String getAll();

    String delete(DeleteProductReq deleteProductReq) throws Exception;

    String update(UpdateProductReq updateProductReq);
}

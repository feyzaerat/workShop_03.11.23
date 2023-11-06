package tobeto_spring_tutorial.business.services.abstracts;

import tobeto_spring_tutorial.data.requests.Product.AddProductReq;
import tobeto_spring_tutorial.data.requests.Product.DeleteProductReq;
import tobeto_spring_tutorial.data.requests.Product.GetProductReq;
import tobeto_spring_tutorial.data.requests.Product.UpdateProductReq;

public interface ProductService {
    String add(AddProductReq addProductReq);

    String get(GetProductReq getProductReq) throws Exception;
    String getAll();

    String delete(DeleteProductReq deleteProductReq) throws Exception;

    String update(UpdateProductReq updateProductReq);
}

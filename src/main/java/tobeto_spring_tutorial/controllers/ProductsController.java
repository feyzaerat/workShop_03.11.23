package tobeto_spring_tutorial.controllers;

import org.springframework.web.bind.annotation.*;
import tobeto_spring_tutorial.business.abstracts.ProductService;
import tobeto_spring_tutorial.requests.Product.AddProductReq;
import tobeto_spring_tutorial.requests.Product.DeleteProductReq;
import tobeto_spring_tutorial.requests.Product.GetProductReq;
import tobeto_spring_tutorial.requests.Product.UpdateProductReq;

@RestController
@RequestMapping("api/product")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProduct")
    public String get(@RequestBody GetProductReq getProductReq) throws Exception {
        return this.productService.get(getProductReq);
    }

    @GetMapping("/getAllProducts")
    public String getAll() {
        return productService.getAll();
    }


    @PostMapping("/addProduct")
    public String add(@RequestBody AddProductReq addProductReq) {
        return this.productService.add(addProductReq);
    }

    @DeleteMapping("/deleteProduct")
    public String delete(@RequestBody DeleteProductReq deleteProductReq) throws Exception {
        return this.productService.delete(deleteProductReq);
    }

    @PutMapping("/updateProduct")
    public String update(@RequestBody UpdateProductReq updateProductReq) {
        return this.productService.update(updateProductReq);
    }

}

package com.example.workShop_0313;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    List<Product> productList = new ArrayList<>();

    @GetMapping
    public List <Product> getProductList(){
        return productList;
    }
    @GetMapping("{id}")
    public Product getByProductId(@PathVariable int id){
        Product product1= productList.stream().filter((p) -> p.getId()== id ).findFirst().orElseThrow();
        return product1;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
       productList.add(product);
    }
    @PutMapping
    public void updateProduct(@RequestBody Product product){
        Product product2 = productList.stream().filter((p) -> p.getId()== product.getId()).findFirst().orElseThrow();

        product2.setProductName(product.getProductName());
        product2.setPrice(product.getPrice());
        product2.setCategoryId(product.getCategoryId());
        product2.setStockAmount(product.getStockAmount());
    }
    //@PutMapping("{id}")
    //public void updateProduct2(@PathVariable int id){
      //  Product product4 = productList.stream().filter((p) -> p.getId()== id).findFirst().orElseThrow();
       // product4.setProductName(product4.getProductName());
    //}
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable int id){
        Product product3 = productList.stream().filter((p) -> p.getId()== id).findFirst().orElseThrow();
        productList.remove(product3);
    }

}

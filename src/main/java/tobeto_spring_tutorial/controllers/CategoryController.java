package tobeto_spring_tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto_spring_tutorial.business.CategoryManager;
import tobeto_spring_tutorial.requests.Category.AddCategoryReq;
import tobeto_spring_tutorial.requests.Category.DeleteCategoryReq;
import tobeto_spring_tutorial.requests.Category.GetCategoryReq;
import tobeto_spring_tutorial.requests.Category.UpdateCategroyReq;
import tobeto_spring_tutorial.responses.TCResponse;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryManager categoryManager;

    @Autowired
    public CategoryController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    @GetMapping("/getCategory")
    public ResponseEntity<TCResponse<?>> getCategory(@RequestBody GetCategoryReq getCategoryReq) {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.categoryManager.get(getCategoryReq))
                .message("Kategori getirildi")
                .build()
        );
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<TCResponse<?>> getAllCategories(){
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.categoryManager.getAll())
                .message("Kategori listesi getirildi")
                .build());
    }

    @PostMapping("/addCategory")
    public ResponseEntity<TCResponse<?>> addCategory(@RequestBody AddCategoryReq addCategoryReq){
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.categoryManager.add(addCategoryReq))
                .message("Kategori eklendi")
                .build()
        );
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<TCResponse<?>> updateCategory(@RequestBody UpdateCategroyReq updateCategroyReq){
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.categoryManager.update(updateCategroyReq))
                .message("Kategori güncellendi")
                .build()
        );

    }

    @DeleteMapping("/deleteCategory")
    public ResponseEntity<TCResponse<?>> deleteCategory(@RequestBody DeleteCategoryReq deleteCategoryReq){
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.categoryManager.delete(deleteCategoryReq))
                .message("Kategori silindi")
                .build()
        );
    }

}

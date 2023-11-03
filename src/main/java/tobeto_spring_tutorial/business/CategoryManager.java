package tobeto_spring_tutorial.business;

import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.DTO.CategoryDTO;
import tobeto_spring_tutorial.business.abstracts.CategoryService;
import tobeto_spring_tutorial.entities.baseEntites.Category;
import tobeto_spring_tutorial.requests.Category.AddCategoryReq;
import tobeto_spring_tutorial.requests.Category.DeleteCategoryReq;
import tobeto_spring_tutorial.requests.Category.GetCategoryReq;
import tobeto_spring_tutorial.requests.Category.UpdateCategroyReq;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private final List<Category> categories = new ArrayList<Category>();

    private int lastId;

    @Override
    public CategoryDTO get(GetCategoryReq getCategory) {

        return findById(getCategory.id()).convertToDTO();
    }

    @Override
    public List<CategoryDTO> getAll() {

        return categories.stream().map(Category::convertToDTO).toList();
    }

    @Override
    public CategoryDTO add(AddCategoryReq addCategoryReq) {
        Category category = Category.builder()
                .name(addCategoryReq.name())
                .build();
        idSetter();
        category.setId(lastId);
        categories.add(category);

        return category.convertToDTO();
    }

    @Override
    public CategoryDTO delete(DeleteCategoryReq deleteCategoryReq) {
        CategoryDTO categoryDTO = findById(deleteCategoryReq.id()).convertToDTO();
        categories.remove(findById(deleteCategoryReq.id()));
        return categoryDTO;
    }

    @Override
    public CategoryDTO update(UpdateCategroyReq updateCategroyReq) {
        Category category = this.findById(updateCategroyReq.id());
        category.setName(updateCategroyReq.newName());

        return category.convertToDTO();
    }

    public void idSetter() {
        if (categories.toArray().length > 0) {
            lastId++;
        }
    }

    public Category findById(int id) {

        return categories.stream().filter((category) -> category.getId() == id).findFirst().orElseThrow();
    }
}

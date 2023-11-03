package tobeto_spring_tutorial.business.abstracts;

import tobeto_spring_tutorial.DTO.CategoryDTO;
import tobeto_spring_tutorial.requests.Category.AddCategoryReq;
import tobeto_spring_tutorial.requests.Category.DeleteCategoryReq;
import tobeto_spring_tutorial.requests.Category.GetCategoryReq;
import tobeto_spring_tutorial.requests.Category.UpdateCategroyReq;
import java.util.List;

public interface CategoryService {

    CategoryDTO get(GetCategoryReq getCategory);

    List<CategoryDTO> getAll();

    CategoryDTO add(AddCategoryReq addCategoryReq);

    CategoryDTO delete(DeleteCategoryReq deleteCategoryReq);

    CategoryDTO update(UpdateCategroyReq updateCategroyReq);

}

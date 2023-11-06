package tobeto_spring_tutorial.business.services.abstracts;

import tobeto_spring_tutorial.data.DTO.CategoryDTO;
import tobeto_spring_tutorial.data.requests.Category.AddCategoryReq;
import tobeto_spring_tutorial.data.requests.Category.DeleteCategoryReq;
import tobeto_spring_tutorial.data.requests.Category.GetCategoryReq;
import tobeto_spring_tutorial.data.requests.Category.UpdateCategroyReq;
import java.util.List;

public interface CategoryService {

    CategoryDTO get(GetCategoryReq getCategory);

    List<CategoryDTO> getAll();

    CategoryDTO add(AddCategoryReq addCategoryReq);

    CategoryDTO delete (DeleteCategoryReq deleteCategoryReq);

    CategoryDTO update(UpdateCategroyReq updateCategroyReq);

}

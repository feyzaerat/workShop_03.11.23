package tobeto_spring_tutorial.business.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_spring_tutorial.business.entityServices.CategoryEntityManager;
import tobeto_spring_tutorial.business.services.abstracts.CategoryService;
import tobeto_spring_tutorial.data.DTO.CategoryDTO;
import tobeto_spring_tutorial.data.entities.CategoryEntity;
import tobeto_spring_tutorial.data.requests.Category.AddCategoryReq;
import tobeto_spring_tutorial.data.requests.Category.DeleteCategoryReq;
import tobeto_spring_tutorial.data.requests.Category.GetCategoryReq;
import tobeto_spring_tutorial.data.requests.Category.UpdateCategroyReq;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryEntityManager categoryEntityManager;
    private final List<CategoryEntity> categories = new ArrayList<CategoryEntity>();


    @Override
    public CategoryDTO get(GetCategoryReq getCategoryReq) {

        return this.categoryEntityManager.getById(getCategoryReq.id()).convertToDTO();
    }


    public CategoryDTO getById(int id) {  //Controller için özel method
        return CategoryDTO.builder()
                .name(this.categoryEntityManager.getById(id).getName())
                .build();
    }

    @Override
    public List<CategoryDTO> getAll() {

        return this.categoryEntityManager.getAllEntities().stream()
                .map(CategoryEntity::convertToDTO).toList();
    }

    @Override
    public CategoryDTO add(AddCategoryReq addCategoryReq) {
        return this.categoryEntityManager.save(addCategoryReq.convertToEntity()).convertToDTO();
    }

    @Override //TODO burada hata verebilir
    public CategoryDTO delete(DeleteCategoryReq deleteCategoryReq) {
        CategoryEntity categoryEntity = this.categoryEntityManager.getById(deleteCategoryReq.id());
        //isdleted true yapıyoruz.// Gelen bilgide silindiği görünsün diye. (softdelete yapıp orada kullanmak daha mantıklı)
        categoryEntity.setIsDeleted(true);
        CategoryDTO tempCategoryDto = categoryEntity.convertToDTO(); //silineceği için dto nesnesi oluşturup yedek olarak aldık
        this.categoryEntityManager.delete(categoryEntity);

        return tempCategoryDto;
    }

    @Override
    public CategoryDTO update(UpdateCategroyReq updateCategroyReq) {

        CategoryEntity categoryEntity = this.categoryEntityManager.getById(updateCategroyReq.id());
        categoryEntity.setName(updateCategroyReq.newName());

        return this.categoryEntityManager.update(categoryEntity).convertToDTO();
    }


    public CategoryEntity findById(int id) { //TODO burası kaldırılacak ama önce product manager daki bağımlılığı kontrol et.

        return categories.stream().filter((categoryEntity) -> categoryEntity.getId() == id).findFirst().orElseThrow();
    }
}

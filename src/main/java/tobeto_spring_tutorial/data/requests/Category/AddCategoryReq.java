package tobeto_spring_tutorial.data.requests.Category;

import tobeto_spring_tutorial.data.entities.CategoryEntity;

public record AddCategoryReq(String name) {

    public CategoryEntity convertToEntity(){
        return CategoryEntity.builder()
                .name(this.name)
                .build();
    }
}

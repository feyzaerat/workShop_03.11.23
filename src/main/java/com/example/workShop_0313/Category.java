package com.example.workShop_0313;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int id;
    private String categoryName;
    private String subCategoryName;
    private String createdAt;
    private String updatedAt;
    private int createdById;
    private int updatedById;
    private int isActive;
}

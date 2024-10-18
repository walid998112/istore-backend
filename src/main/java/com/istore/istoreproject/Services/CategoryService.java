package com.istore.istoreproject.Services;


import java.util.List;

import com.istore.istoreproject.models.Category;

public interface CategoryService {

    void addCategory(Category category);

    void deleteCategory(long id);

    List<Category> getParents();

    List<Category> getByParentId(long id);

    


}

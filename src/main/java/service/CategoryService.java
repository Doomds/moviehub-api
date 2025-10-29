package service;

import entity.Category;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.CategoryRepository;

import java.util.List;

@ApplicationScoped
public class CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    public List<Category> getAllCategoriesSorted() {
        return categoryRepository.listAll(Sort.by("name"));
    }

    public Category findCategoryById(long id) {
        return categoryRepository.findById(id);
    }

}

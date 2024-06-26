package fit.hutech.NguyenVanHung_Buoi2.services;

import fit.hutech.NguyenVanHung_Buoi2.entities.Category;
import fit.hutech.NguyenVanHung_Buoi2.repositories.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final ICategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(@NotNull Category category) {
        Category existingCategory = categoryRepository.findById(category.getCateId()).orElse(null);
        if (existingCategory != null) {
            existingCategory.setCateName(category.getCateName());
            categoryRepository.save(existingCategory);
        }
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}

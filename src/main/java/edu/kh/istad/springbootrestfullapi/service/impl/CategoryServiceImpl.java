package edu.kh.istad.springbootrestfullapi.service.impl;

import edu.kh.istad.springbootrestfullapi.dto.CategoryCreateRequest;
import edu.kh.istad.springbootrestfullapi.dto.CategoryResposne;
import edu.kh.istad.springbootrestfullapi.model.Category;
import edu.kh.istad.springbootrestfullapi.repository.CategoryRepository;
import edu.kh.istad.springbootrestfullapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResposne> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> CategoryResposne.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .icon(category.getIcon())
                        .build())
                .toList();
    }

    @Override
    public CategoryResposne getById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category Not Found"
                ));

        return CategoryResposne.builder()
                .id(category.getId())
                .name(category.getName())
                .icon(category.getIcon())
                .build();
    }

    @Override
    public CategoryResposne create(CategoryCreateRequest categoryCreateRequest) {
        Category category = new Category();
        category.setName(categoryCreateRequest.name());
        category.setIcon(categoryCreateRequest.icon());

        Category savedCategory = categoryRepository.save(category);

        return CategoryResposne.builder()
                .id(savedCategory.getId())
                .name(savedCategory.getName())
                .icon(savedCategory.getIcon())
                .build();
    }

    @Override
    public void deleteById(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Category Not Found"
            );
        }
        categoryRepository.deleteById(id);
    }

}
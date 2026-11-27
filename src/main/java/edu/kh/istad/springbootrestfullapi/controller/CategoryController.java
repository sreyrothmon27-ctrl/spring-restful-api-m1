package edu.kh.istad.springbootrestfullapi.controller;

import edu.kh.istad.springbootrestfullapi.dto.CategoryCreateRequest;
import edu.kh.istad.springbootrestfullapi.dto.CategoryResposne;
import edu.kh.istad.springbootrestfullapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResposne> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryResposne getById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryResposne create(@RequestBody CategoryCreateRequest categoryCreateRequest) {
        return categoryService.create(categoryCreateRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
    }

}
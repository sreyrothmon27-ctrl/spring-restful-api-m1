package edu.kh.istad.springbootrestfullapi.service;

import edu.kh.istad.springbootrestfullapi.dto.CategoryCreateRequest;
import edu.kh.istad.springbootrestfullapi.dto.CategoryResposne;

import java.util.List;

public interface CategoryService {

    List<CategoryResposne> getAll();

    CategoryResposne getById(Integer id);

    CategoryResposne create(CategoryCreateRequest categoryCreateRequest);

    void deleteById(Integer id);

}
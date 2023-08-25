package com.favouritemanager.api.controller;

import com.favouritemanager.api.dto.CategoryListItem;
import com.favouritemanager.api.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/get")
    List<CategoryListItem> findAll() {
        return categoryService.findAll();
    }
}

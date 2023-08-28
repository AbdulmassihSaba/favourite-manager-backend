package com.favouritemanager.api.controller;

import com.favouritemanager.api.dto.CategoryListItem;
import com.favouritemanager.api.persistance.entity.Category;
import com.favouritemanager.api.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("http://127.0.0.1:5500")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Operation(summary = "Get the list of all existing categories")
    @GetMapping("/get")
    List<CategoryListItem> findAll() {
        return categoryService.findAll();
    }

}

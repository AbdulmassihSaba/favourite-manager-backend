package com.favouritemanager.api.service;

import com.favouritemanager.api.dto.CategoryListItem;

import java.util.List;

public interface ICategoryService {
    List<CategoryListItem> findAll();
}

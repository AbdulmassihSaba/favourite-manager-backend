package com.favouritemanager.api.service.impl;

import com.favouritemanager.api.dto.CategoryListItem;
import com.favouritemanager.api.persistance.entity.Category;
import com.favouritemanager.api.persistance.repository.CategoryRepository;
import com.favouritemanager.api.service.ICategoryService;
import com.favouritemanager.api.utils.DTOHelper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DTOHelper dtoHelper;
    // The method findAll exists already, override allows to reconfigure it
    @Override
    public List<CategoryListItem> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> dtoHelper.toCategoryListItem(category))
                .toList();
    }

}

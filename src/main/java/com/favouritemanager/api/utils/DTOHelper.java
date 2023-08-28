package com.favouritemanager.api.utils;

import com.favouritemanager.api.dto.CategoryListItem;
import com.favouritemanager.api.dto.FavouriteItem;
import com.favouritemanager.api.dto.FavouriteListItem;
import com.favouritemanager.api.persistance.entity.Category;
import com.favouritemanager.api.persistance.entity.Item;
import com.favouritemanager.api.persistance.repository.CategoryRepository;
import com.favouritemanager.api.persistance.repository.FavouriteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOHelper {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FavouriteRepository favouriteRepository;

    private ModelMapper mapper = new ModelMapper();

    public CategoryListItem toCategoryListItem(Category category) {
        CategoryListItem dto  = mapper.map(category, CategoryListItem.class);
        dto.setReferences(
                favouriteRepository.findAll()
                        .stream()
                        .filter(f -> f.getCategory().getId().equals(category.getId()))
                        .toList()
                        .size()
        );
        return dto;
    }

    public FavouriteListItem toFavouriteListItem(Item item) {
        FavouriteListItem dto = mapper.map(item, FavouriteListItem.class);
        return dto;
    }

    public FavouriteItem toFavouriteItem(Item item) {
        FavouriteItem dto = mapper.map(item, FavouriteItem.class);
        return dto;
    }


}

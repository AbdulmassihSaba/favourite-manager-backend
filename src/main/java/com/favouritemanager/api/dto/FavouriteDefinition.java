package com.favouritemanager.api.dto;

import com.favouritemanager.api.persistance.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavouriteDefinition {
    private Long id;
    private Long categoryId;
    private String label;
    private String link;
}

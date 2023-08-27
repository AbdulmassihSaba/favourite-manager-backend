package com.favouritemanager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavouriteItem {
    private Long id;
    private String categoryName;
    private String label;
    private String link;
    private String updatedAt;
}

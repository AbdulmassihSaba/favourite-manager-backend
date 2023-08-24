package com.favouritemanager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavouriteListItem {
    private Long id;
    private String categoryName;
    private String link;
    private String updatedAt;
}

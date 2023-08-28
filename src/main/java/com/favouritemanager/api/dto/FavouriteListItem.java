package com.favouritemanager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteListItem {
    private Long id;
    private String categoryName;
    private String link;
    private String updatedAt;
}

package com.favouritemanager.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteItem {
    private long id;
    private String categoryName;
    private String label;
    private String link;
    private String updatedAt;
}

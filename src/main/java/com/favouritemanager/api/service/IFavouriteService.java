package com.favouritemanager.api.service;

import com.favouritemanager.api.dto.*;

import java.util.List;

public interface IFavouriteService {
    List<FavouriteListItem> findAll(ItemSortBy sortBy, ItemSortType sortType, Long categoryId);
    FavouriteItem addItem(FavouriteDefinition item);

    void deleteItems(String ids);

}

package com.favouritemanager.api.service;

import com.favouritemanager.api.dto.FavouriteListItem;
import com.favouritemanager.api.dto.ItemSortBy;
import com.favouritemanager.api.dto.ItemSortType;

import java.util.List;

public interface IFavouriteService {
    List<FavouriteListItem> findAll(ItemSortBy sortBy, ItemSortType sortType, Long categoryId);
}

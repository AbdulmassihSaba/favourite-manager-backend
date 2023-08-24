package com.favouritemanager.api.service;

import com.favouritemanager.api.dto.FavouriteListItem;

import java.util.List;

public interface IFavouriteService {
    List<FavouriteListItem> findAll();
}

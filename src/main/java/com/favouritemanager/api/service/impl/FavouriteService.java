package com.favouritemanager.api.service.impl;

import com.favouritemanager.api.dto.FavouriteListItem;
import com.favouritemanager.api.persistance.repository.ItemRepository;
import com.favouritemanager.api.service.IFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService implements IFavouriteService {
    @Autowired
    private ItemRepository favouriteRepository;

    // The method findAll exists already, override allows to reconfigure it
    @Override
    public List<FavouriteListItem> findAll() {
        return favouriteRepository.findAll()
                .stream()
                .map(entity -> new FavouriteListItem(entity.getId(), entity.getCategory().getName(), entity.getLink(),
                        entity.getUpdatedAt()))
                .toList();
    }
}

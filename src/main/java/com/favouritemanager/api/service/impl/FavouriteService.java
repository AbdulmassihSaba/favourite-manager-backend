package com.favouritemanager.api.service.impl;

import com.favouritemanager.api.dto.FavouriteListItem;
import com.favouritemanager.api.dto.ItemSortBy;
import com.favouritemanager.api.persistance.entity.Item;
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
    public List<FavouriteListItem> findAll(ItemSortBy sortBy) {
        List<Item> list = null;
        if(sortBy.equals(ItemSortBy.category))
        {
            list = favouriteRepository.findAllByOrderByCategoryAsc();

        } else if (sortBy.equals(ItemSortBy.updateTime)) {
            list = favouriteRepository.findAllByOrderByUpdatedAtAsc();
        }

        return list
                .stream()
                .map(entity -> new FavouriteListItem(entity.getId(), entity.getCategory().getName(), entity.getLink(),
                        entity.getUpdatedAt()))
                .toList();
    }
}

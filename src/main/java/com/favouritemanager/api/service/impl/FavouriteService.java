package com.favouritemanager.api.service.impl;

import com.favouritemanager.api.dto.FavouriteListItem;
import com.favouritemanager.api.dto.ItemSortBy;
import com.favouritemanager.api.dto.ItemSortType;
import com.favouritemanager.api.persistance.entity.Category;
import com.favouritemanager.api.persistance.entity.Item;
import com.favouritemanager.api.persistance.repository.ItemRepository;
import com.favouritemanager.api.service.IFavouriteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FavouriteService implements IFavouriteService {
    @Autowired
    private ItemRepository favouriteRepository;

    // The method findAll exists already, override allows to reconfigure it
    @Override
    public List<FavouriteListItem> findAll(ItemSortBy sortBy, ItemSortType sortType, String category) {

        List<Item> list = favouriteRepository.findAll();

        if(sortBy == null)
        {
            if(category == null)
                list = favouriteRepository.findAll();
            else
                list = favouriteRepository.findByCategoryName(category);
        }
        else if(sortBy.equals(ItemSortBy.category)) {
            if(category == null) {
                if(sortType == ItemSortType.ASC)
                    list = favouriteRepository.findAllByOrderByCategoryNameAsc();
                else
                    list = favouriteRepository.findAllByOrderByCategoryNameDesc();
            }
            else {
                if(sortType == ItemSortType.ASC)
                    list = favouriteRepository.findByCategoryNameOrderByCategoryNameDesc(category);
                else
                    list = favouriteRepository.findByCategoryNameOrderByCategoryNameAsc(category);
            }
        } else if (sortBy.equals(ItemSortBy.updateTime)) {
            if(category == null) {
                if(sortType == ItemSortType.ASC)
                    list = favouriteRepository.findAllByOrderByUpdatedAtAsc();
                else
                    list = favouriteRepository.findAllByOrderByUpdatedAtDesc();
            }
            else {
                if(sortType == ItemSortType.ASC)
                    list = favouriteRepository.findByCategoryNameOrderByUpdatedAtAsc(category);
                else
                    list = favouriteRepository.findByCategoryNameOrderByUpdatedAtDesc(category);
            }

        }

        return list
                .stream()
                .map(entity -> new FavouriteListItem(entity.getId(), entity.getCategory().getName(), entity.getLink(),
                        entity.getUpdatedAt()))
                .toList();
    }
}

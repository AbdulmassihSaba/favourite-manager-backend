package com.favouritemanager.api.service.impl;

import com.favouritemanager.api.dto.*;
import com.favouritemanager.api.exception.BadRequestException;
import com.favouritemanager.api.persistance.entity.Category;
import com.favouritemanager.api.persistance.entity.Item;
import com.favouritemanager.api.persistance.repository.CategoryRepository;
import com.favouritemanager.api.persistance.repository.FavouriteRepository;
import com.favouritemanager.api.service.IFavouriteService;
import com.favouritemanager.api.utils.DTOHelper;
import com.favouritemanager.api.utils.Time;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class FavouriteService implements IFavouriteService {
    @Autowired
    private FavouriteRepository favouriteRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DTOHelper dtoHelper;
    // The method findAll exists already, override allows to reconfigure it
    @Override
    public List<FavouriteListItem> findAll(ItemSortBy sortBy, ItemSortType sortType, Long categoryId) {

        List<Item> list = favouriteRepository.findAll();
        if(sortBy == null)
        {
            if(categoryId == null)
                list = favouriteRepository.findAll();
            else
                list = favouriteRepository.findByCategoryId(categoryId);
        }
        else if(sortBy.equals(ItemSortBy.category)) {
            if(categoryId == null) {
                if(sortType == ItemSortType.ASC)
                    list = favouriteRepository.findAllByOrderByCategoryNameAsc();
                else
                    list = favouriteRepository.findAllByOrderByCategoryNameDesc();
            }
            else {
                if(sortType == ItemSortType.ASC)
                    list = favouriteRepository.findByCategoryIdOrderByCategoryNameDesc(categoryId);
                else
                    list = favouriteRepository.findByCategoryIdOrderByCategoryNameAsc(categoryId);
            }
        } else if (sortBy.equals(ItemSortBy.updateTime)) {
            if(categoryId == null) {
                if(sortType == ItemSortType.ASC)
                    list = favouriteRepository.findAllByOrderByUpdatedAtAsc();
                else
                    list = favouriteRepository.findAllByOrderByUpdatedAtDesc();
            }
            else {
                if(sortType == ItemSortType.ASC)
                    list = favouriteRepository.findByCategoryIdOrderByUpdatedAtAsc(categoryId);
                else
                    list = favouriteRepository.findByCategoryIdOrderByUpdatedAtDesc(categoryId);
            }

        }

        return list
                .stream()
                .map(entity -> dtoHelper.toFavouriteListItem(entity))
                .toList();
    }
    @Override
    public FavouriteItem addItem(FavouriteDefinition item) {
        Category category =
                categoryRepository.findById(item.getCategoryId()).orElseThrow(() -> new BadRequestException("The " +
                        "selected category was not found"));
        Item savedItem = favouriteRepository.save(new Item(item.getId(), category, item.getLink(), item.getLabel(),
                Time.getCurrentDateTime()));
        return dtoHelper.toFavouriteItem(savedItem);
    }

    @Override
    public void deleteItems(String ids) {
        Arrays.stream(ids.split(","))
                .map(String::trim)
                .map(Long::valueOf)
                .forEach(id -> favouriteRepository.deleteById(id));
    }
}

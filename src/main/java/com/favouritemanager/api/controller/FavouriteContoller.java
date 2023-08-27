package com.favouritemanager.api.controller;

import com.favouritemanager.api.dto.*;
import com.favouritemanager.api.service.IFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourite")
public class FavouriteContoller {
    @Autowired
    private IFavouriteService favouriteService;

    @GetMapping("/get")
    List<FavouriteListItem> findAll(@RequestParam(required = false) ItemSortBy sortBy,
                                    @RequestParam(required = false) Long categoryId,
                                    @RequestParam(required = false) ItemSortType sortType) {
        return favouriteService.findAll(sortBy, sortType, categoryId);
    }
    @PostMapping("/add")
    FavouriteItem addItem(@RequestBody FavouriteDefinition item) {
        return favouriteService.addItem(item);
    }


}

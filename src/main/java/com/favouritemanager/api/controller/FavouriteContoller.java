package com.favouritemanager.api.controller;

import com.favouritemanager.api.dto.*;
import com.favouritemanager.api.service.IFavouriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourite")
@CrossOrigin("http://127.0.0.1:5500")
public class FavouriteContoller {
    @Autowired
    private IFavouriteService favouriteService;

    @Operation(summary = "Get all favourites sorted by (sortBy) and filtered by (categoryId)")
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

    @DeleteMapping("/delete")
    void deleteItems(@RequestParam String ids) {
        favouriteService.deleteItems(ids);
    }


}

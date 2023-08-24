package com.favouritemanager.api.controller;

import com.favouritemanager.api.dto.FavouriteListItem;
import com.favouritemanager.api.service.IFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/favourite")
public class FavouriteContoller {
    @Autowired
    private IFavouriteService favouriteService;

    @GetMapping("/get")
    List<FavouriteListItem> findAll() {
        return favouriteService.findAll();
    }

}

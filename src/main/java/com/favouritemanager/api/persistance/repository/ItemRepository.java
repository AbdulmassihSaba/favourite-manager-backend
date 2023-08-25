package com.favouritemanager.api.persistance.repository;

import com.favouritemanager.api.persistance.entity.Category;
import com.favouritemanager.api.persistance.entity.Item;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Override
    @EntityGraph(attributePaths = "category")
    List<Item> findAll();

    List<Item> findAllByOrderByUpdatedAtAsc();
    List<Item> findAllByOrderByUpdatedAtDesc();
    List<Item> findAllByOrderByCategoryNameAsc();
    List<Item> findAllByOrderByCategoryNameDesc();
    List<Item> findByCategoryNameOrderByUpdatedAtDesc(String categoryName);
    List<Item> findByCategoryNameOrderByUpdatedAtAsc(String categoryName);
    List<Item> findByCategoryNameOrderByCategoryNameDesc(String categoryName);
    List<Item> findByCategoryNameOrderByCategoryNameAsc(String categoryName);
    List<Item> findByCategoryName(String categoryName);

}
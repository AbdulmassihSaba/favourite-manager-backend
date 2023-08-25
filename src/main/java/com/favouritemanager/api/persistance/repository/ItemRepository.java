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
    List<Item> findByCategoryIdOrderByUpdatedAtDesc(Long categoryId);
    List<Item> findByCategoryIdOrderByUpdatedAtAsc(Long categoryId);
    List<Item> findByCategoryIdOrderByCategoryNameDesc(Long categoryId);
    List<Item> findByCategoryIdOrderByCategoryNameAsc(Long categoryId);
    List<Item> findByCategoryId(Long categoryId);

}
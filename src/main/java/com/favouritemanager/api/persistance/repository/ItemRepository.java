package com.favouritemanager.api.persistance.repository;

import com.favouritemanager.api.persistance.entity.Item;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Override
    @EntityGraph(attributePaths = "category")
    List<Item> findAll();

    List<Item> findAllByOrderByUpdatedAtAsc();

    List<Item> findAllByOrderByCategoryAsc();

}
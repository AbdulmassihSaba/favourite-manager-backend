package com.favouritemanager.api.persistance.repository;

import com.favouritemanager.api.persistance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package org.blb.repository.rent;

import org.blb.models.region.Region;
import org.blb.models.rent.Category;
import org.blb.models.rent.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);
    List<Product> findAllByCategory(Category category);
    List<Product> findAllByUserId(Long userId);

    List<Product> findAllByRegion(Region region);

    List<Product> findAllByRegionAndCategory(Region region, Category category);

    //игнорируя регистр
    List<Product> findByNameStartingWithIgnoreCase(String name);

    List<Product> findAllByRegionAndNameStartingWithIgnoreCase(Region region, String name);

    List<Product> findAllByRegionAndCategoryAndNameStartingWithIgnoreCase(Region region, Category category, String name);

    List<Product> findAllByCategoryAndNameStartingWithIgnoreCase(Category category, String name);
}

package com.ph.springbootcrud.repository;

import com.ph.springbootcrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> getAllByName(@Param("name") String name);
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> getAllByNameLike(String name);

}

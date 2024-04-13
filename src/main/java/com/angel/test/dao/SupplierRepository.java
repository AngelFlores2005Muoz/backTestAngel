package com.angel.test.dao;

import com.angel.test.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query(nativeQuery= true, value="SELECT nombre FROM supplier WHERE nombre = :name")
    String findByNombre(String name);

}

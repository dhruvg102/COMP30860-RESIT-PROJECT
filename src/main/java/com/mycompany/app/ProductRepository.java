package com.mycompany.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.entities.MyProduct;

@Repository
public interface ProductRepository extends JpaRepository<MyProduct,Long>{}
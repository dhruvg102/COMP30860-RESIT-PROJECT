package com.mycompany.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.entities.MyOrder;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder,Long>{}
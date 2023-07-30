package com.mycompany.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.entities.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long>{}
package com.prashantMaurya.PSO.Repo;

import com.prashantMaurya.PSO.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends JpaRepository<UserEntity, Long> {

  UserEntity findByUsername(String username);
}

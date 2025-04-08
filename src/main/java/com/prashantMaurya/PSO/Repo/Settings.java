package com.prashantMaurya.PSO.Repo;

import com.prashantMaurya.PSO.Entities.SettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Settings extends JpaRepository<SettingsEntity, Long> {}

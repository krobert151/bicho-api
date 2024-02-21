package com.robertorebolledonaharro.bichoapi.level.repo;

import com.robertorebolledonaharro.bichoapi.level.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, UUID> {
}

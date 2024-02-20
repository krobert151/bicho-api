package com.robertorebolledonaharro.bichoapi.specie.repo;

import com.robertorebolledonaharro.bichoapi.specie.model.Specie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecieRepository extends JpaRepository<Specie, UUID> {
}

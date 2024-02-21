package com.robertorebolledonaharro.bichoapi.encounters.repo;

import com.robertorebolledonaharro.bichoapi.encounters.model.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, UUID> {
}

package com.robertorebolledonaharro.bichoapi.specie.repo;

import com.robertorebolledonaharro.bichoapi.specie.dto.SpecieSimpleDTO;
import com.robertorebolledonaharro.bichoapi.specie.model.Specie;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;

public interface SpecieRepository extends JpaRepository<Specie, UUID> {

    @Query("""
            SELECT new com.robertorebolledonaharro.bichoapi.specie.dto.SpecieSimpleDTO(
            e.id,
            m.archive,
            e.scientificName           
            ) FROM Specie e
            LEFT JOIN e.media as m
            WHERE e.danger >2
            """)
    List<SpecieSimpleDTO> findSpeciesInDangerOfExtintion(PageRequest pageable);

    Optional<Specie> findByScientificName(String name);


}

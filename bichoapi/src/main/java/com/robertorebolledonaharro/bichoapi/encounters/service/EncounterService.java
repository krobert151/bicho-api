package com.robertorebolledonaharro.bichoapi.encounters.service;

import com.robertorebolledonaharro.bichoapi.encounters.dto.EncounterDTO;
import com.robertorebolledonaharro.bichoapi.encounters.dto.EncounterSimpleDTO;
import com.robertorebolledonaharro.bichoapi.encounters.error.EncounterNotFoundException;
import com.robertorebolledonaharro.bichoapi.encounters.model.Encounter;
import com.robertorebolledonaharro.bichoapi.encounters.repo.EncounterRepository;
import com.robertorebolledonaharro.bichoapi.media.model.Media;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EncounterService {

    private final EncounterRepository repository;



    public List<EncounterSimpleDTO> findMostLikedEncounters(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<EncounterSimpleDTO> encounterPage = repository.findEncounterMostLiked(pageable);

        if (encounterPage.hasContent()) {
            return encounterPage.getContent();
        } else {
            throw new EncounterNotFoundException("No encounters found on page " + page);
        }
    }

    public List<Media> getMediasByEncounterId(UUID encounterId) {
        Optional<Encounter> optionalEncounter = repository.findById(encounterId);
        if (optionalEncounter.isPresent()) {
            Encounter encounter = optionalEncounter.get();
            // Accede a las medias para forzar su carga perezosa
            List<Media> medias = encounter.getMedias();
            // Ahora las medias están cargadas y puedes manipularlas
            return medias;
        } else {
            // Manejar si no se encuentra el encuentro
            return Collections.emptyList();
        }
    }
    @Transactional
    public List<EncounterDTO> findEncounters(int page, int count) {
        Pageable pageable = PageRequest.of(page, count);
        Page<Encounter> encounterPage = repository.findAll(pageable);

        if (encounterPage.hasContent()) {
            return encounterPage.getContent().stream().map(
                    encounter -> {

                        List<Media> medias = getMediasByEncounterId(encounter.getId());

                        return EncounterDTO.builder()
                                .id(encounter.getId())
                                .scientificName(encounter.getSpecie().getScientificName())
                                .type(encounter.getSpecie().getType())
                                .url(medias.get(0).getArchive())
                                .build();
                    }
            ).toList();
        } else {
            throw new EncounterNotFoundException("No encounters found on page " + page);
        }
    }


}

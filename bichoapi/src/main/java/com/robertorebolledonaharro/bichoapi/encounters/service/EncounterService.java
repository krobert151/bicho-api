package com.robertorebolledonaharro.bichoapi.encounters.service;

import com.robertorebolledonaharro.bichoapi.encounters.dto.EncounterDTO;
import com.robertorebolledonaharro.bichoapi.encounters.dto.EncounterSimpleDTO;
import com.robertorebolledonaharro.bichoapi.encounters.error.EncounterNotFoundException;
import com.robertorebolledonaharro.bichoapi.encounters.model.Encounter;
import com.robertorebolledonaharro.bichoapi.encounters.repo.EncounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<EncounterDTO> findEncounters(int page, int count){
        Pageable pageable = PageRequest.of(page,count);
        Page<Encounter> encounterPage= repository.findAll(pageable);

        if (encounterPage.hasContent()) {
            return encounterPage.getContent().stream().map(
                    encounter -> {

                        String url;

                        if (encounter.getMedias().isEmpty()) {
                            url = "Manolo";
                        } else {
                            url = encounter.getMedias().get(0).getArchive();
                        }

                        return EncounterDTO.builder()
                                .id(encounter.getId())
                                .scientificName(encounter.getSpecie().getScientificName())
                                .type(encounter.getSpecie().getType())
                                .url(url)
                                .build();
                    }

            ).toList();
        } else {
            throw new EncounterNotFoundException("No encounters found on page " + page);
        }


    }

}

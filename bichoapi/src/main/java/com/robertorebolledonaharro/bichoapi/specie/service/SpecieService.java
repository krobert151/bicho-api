package com.robertorebolledonaharro.bichoapi.specie.service;

import com.robertorebolledonaharro.bichoapi.specie.dto.SpecieSimpleDTO;
import com.robertorebolledonaharro.bichoapi.specie.error.SpecieNotFoundException;
import com.robertorebolledonaharro.bichoapi.specie.model.Specie;
import com.robertorebolledonaharro.bichoapi.specie.repo.SpecieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecieService {

    private final SpecieRepository repository;


    public List<SpecieSimpleDTO> findSpeciesfromHome(int page, int count){
        Pageable pageable = PageRequest.of(page,count);
        Page<SpecieSimpleDTO> speciesPage = repository.findSpeciesInDangerOfExtintion(pageable);

        if(speciesPage.hasContent()){
            return speciesPage.getContent();

        }else {
            throw new SpecieNotFoundException("No Species was found on page "+page);
        }



    }






}

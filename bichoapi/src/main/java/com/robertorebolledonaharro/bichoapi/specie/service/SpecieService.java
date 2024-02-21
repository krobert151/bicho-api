package com.robertorebolledonaharro.bichoapi.specie.service;

import com.robertorebolledonaharro.bichoapi.specie.dto.SpecieSimpleDTO;
import com.robertorebolledonaharro.bichoapi.specie.model.Specie;
import com.robertorebolledonaharro.bichoapi.specie.repo.SpecieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecieService {

    private final SpecieRepository repository;


    public List<SpecieSimpleDTO> findSpeciesfromHome(){

        return repository.findSpeciesInDangerOfExtintion(PageRequest.of(0,20));

    }






}

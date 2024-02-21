package com.robertorebolledonaharro.bichoapi.specie.controller;

import com.robertorebolledonaharro.bichoapi.specie.dto.SpecieSimpleDTO;
import com.robertorebolledonaharro.bichoapi.specie.service.SpecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class SpecieController {

    private final SpecieService specieService;

    @GetMapping("/species/home")
    public ResponseEntity<List<SpecieSimpleDTO>> getDangerSpecies(){
        return  ResponseEntity.ok().body(specieService.findSpeciesfromHome());
    }


}

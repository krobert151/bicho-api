package com.robertorebolledonaharro.bichoapi.encounters.controller;


import com.robertorebolledonaharro.bichoapi.encounters.dto.EncounterDTO;
import com.robertorebolledonaharro.bichoapi.encounters.dto.EncounterSimpleDTO;
import com.robertorebolledonaharro.bichoapi.encounters.service.EncounterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/encounters")
public class EncounterController {

    private final EncounterService encounterService;

    @Operation(summary = "Get most liked species", description = "Retrieve a list of most liked species with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of most liked species returned successfully", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EncounterSimpleDTO.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": "80d768ef-871a-4cfe-9426-fda1eb490464",
                                                    "scientificName": "Pleurodelest walts",
                                                    "description": "descripcion",
                                                    "photo": "https://i.pinimg.com/564x/f8/19/94/f81994a18d2f74abf23c2ae79b1bceb2.jpg"
                                                },
                                                {
                                                    "id": "80d768ef-871a-4cfe-9426-fda1eb490455",
                                                    "scientificName": "American Eagle",
                                                    "description": "descripcion",
                                                    "photo": "https://i.pinimg.com/564x/04/10/44/04104419e02e72560d0f0c6cff8a8be2.jpg"
                                                },
                                                {
                                                    "id": "80d768ef-871a-4cfe-9426-fda1eb490495",
                                                    "scientificName": "Gineta",
                                                    "description": "descripcion",
                                                    "photo": "https://i.pinimg.com/564x/79/94/81/799481a982a56e439756668a19bf35aa.jpg"
                                                }
                                            ]                                          
                                            """

                            )}
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/most-liked/simple")
    public ResponseEntity<List<EncounterSimpleDTO>> getMostLikedSpecies(
            @Parameter(description = "Number of items per page") @RequestParam(value = "c", required = false, defaultValue = "10") int count,
            @Parameter(description = "Page number") @RequestParam(value = "p", required = false, defaultValue = "0") int page) {
        return ResponseEntity.ok().body(encounterService.findMostLikedEncounters(page, count));
    }

    @GetMapping("/allencounters")
    public ResponseEntity<List<EncounterDTO>> findAllByCriteria(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "c", required = false, defaultValue = "10") int count,
            @RequestParam(value = "p", required = false, defaultValue = "0") int page
    ){
        if(search == null){
            return ResponseEntity.ok(encounterService.findEncounters(page, count));
        }else{
            return ResponseEntity.ok(encounterService.findEncounters(page, count));
        }
    }

}

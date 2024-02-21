package com.robertorebolledonaharro.bichoapi.specie.controller;

import com.robertorebolledonaharro.bichoapi.specie.dto.SpecieSimpleDTO;
import com.robertorebolledonaharro.bichoapi.specie.service.SpecieService;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/species")
public class SpecieController {

    private final SpecieService specieService;

    @Operation(summary = "Get species at risk of extinction", description = "Retrieve a list of species at risk of extinction with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of species at risk of extinction returned successfully", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = SpecieSimpleDTO.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": "80d768ef-831a-4cfe-9426-fda1eb456464",
                                                    "url": "https://i.pinimg.com/564x/79/94/81/799481a982a56e439756668a19bf35aa.jpg",
                                                    "scientificName": "Gineta"
                                                },
                                                {
                                                    "id": "80d768ef-831a-4cfe-94e6-fda1eb444464",
                                                    "url": "https://i.pinimg.com/564x/c6/31/8d/c6318d184cf1153eb4cf71db7937a214.jpg",
                                                    "scientificName": "American Eagle"
                                                }
                                            ]                                         
                                            """

                            )}
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/danger-extinction/simple")
    public ResponseEntity<List<SpecieSimpleDTO>> getDangerSpecies(
            @Parameter(description = "Number of items per page") @RequestParam(value = "c", required = false, defaultValue = "10") int count,
            @Parameter(description = "Page number") @RequestParam(value = "p", required = false, defaultValue = "0") int page) {
        return ResponseEntity.ok().body(specieService.findSpeciesfromHome(page,count));
    }



}

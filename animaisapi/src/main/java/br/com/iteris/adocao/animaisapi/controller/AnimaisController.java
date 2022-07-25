package br.com.iteris.adocao.animaisapi.controller;

import br.com.iteris.adocao.animaisapi.controller.domain.dto.AnimalCreateRequest;
import br.com.iteris.adocao.animaisapi.controller.domain.dto.AnimalResponse;
import br.com.iteris.adocao.animaisapi.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AnimaisController {

    private final AnimalService animalService;

    public AnimaisController(final AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(value = "api/animais")
    public ResponseEntity<List<AnimalResponse>> listarTodos() {
        return ResponseEntity.ok(animalService.listarTodos());
    }

    @GetMapping(value = "api/animais/{id}")
    public ResponseEntity<AnimalResponse> buscarId(@PathVariable Integer id) {
        return ResponseEntity.ok(animalService.buscarId(id));
    }

    @PostMapping(value = "api/animais")
    public ResponseEntity<AnimalResponse> cadastrarAnimal(@RequestBody @Valid AnimalCreateRequest createRequest) {
        return ResponseEntity.ok(animalService.cadastrarAnimal(createRequest));
    }
}

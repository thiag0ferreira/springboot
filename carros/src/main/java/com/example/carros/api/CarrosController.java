package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
    @Autowired
    private CarroService service;

    @PostMapping("/findAll")
    public ResponseEntity<List<CarroDTO>> findAllCarros() {
        List<CarroDTO> response = service.getCarros();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> getCarroById(@PathVariable("id") Long id) {
        Optional<CarroDTO> carro = service.getCarroById(id);

        if (carro.isPresent()) {
            return ResponseEntity.ok(carro.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<CarroDTO>> getCarrosByTipo(@PathVariable("tipo") String tipo) {
        List<CarroDTO> carros = service.getCarroByTipo(tipo);

        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);

    }


    @PostMapping
    public ResponseEntity<CarroDTO> saveCarro(@RequestBody Carro carro) {
        CarroDTO carroSaved = service.insert(carro);
        return ResponseEntity.ok(carroSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroDTO> put(@PathVariable("id") Long id, @RequestBody Carro carro) {

        carro.setId(id);

        CarroDTO carroUpdated = service.update(carro, id);

        return carroUpdated != null ?
                ResponseEntity.ok(carroUpdated) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return
                ResponseEntity.ok().build();
    }
}

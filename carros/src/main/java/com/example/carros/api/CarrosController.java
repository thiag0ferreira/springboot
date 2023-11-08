package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
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

    @GetMapping()
    public ResponseEntity<Iterable<Carro>> get() {
        return ResponseEntity.ok(service.getCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Carro> carro = service.getCarroById(id);

        if(carro.isPresent()){
            return ResponseEntity.ok(carro.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {
        List<Carro> carros = service.getCarroByTipo(tipo);

        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);

    }


    @PostMapping
    public String post(@RequestBody Carro carro) {
        Carro c = service.save(carro);

        return "Carro salvo com sucesso: " + c.getId();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Carro carro){
        Carro c = service.update(carro, id);

        return "Carro atualizado com sucesso: " + c.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);

        return "Carro deletado com sucesso!";
    }
}

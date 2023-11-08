package com.example.carros.domain;

import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros() {
        List<Carro> carros = rep.findAll();

        List<CarroDTO> list = new ArrayList<>();
        for (Carro c : carros){
            list.add(new CarroDTO(c));
        }
        return list;
    }

    public Optional<CarroDTO> getCarroById(Long id) {
        return rep.findById(id).map(CarroDTO::new);
    }

    public List <CarroDTO> getCarroByTipo(String tipo) {
        List<Carro> carros = rep.findAll();

        List<CarroDTO> list = new ArrayList<>();
        for (Carro c : carros){
            list.add(new CarroDTO(c));
        }
        return list;
    }

    public Carro save(Carro carro) {
        return rep.save(carro);
    }

    public Carro update(Carro carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        //Busca o carro no BD
        Optional<CarroDTO> optional = getCarroById(id);
        if(optional.isPresent()) {
            CarroDTO db = optional.get();
            //Copiar as propriedades de Carro nome e tipo
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            //Atualiza o carro
            rep.save(db);

            return db;
        }else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }

    }

    public void delete(Long id) {

        if(getCarroById(id).isPresent()) {
            rep.deleteById(id);
        }
    }
}
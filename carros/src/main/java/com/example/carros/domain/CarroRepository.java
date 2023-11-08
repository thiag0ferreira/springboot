package com.example.carros.domain;

import com.example.carros.domain.dto.CarroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByTipo(String tipo);
}

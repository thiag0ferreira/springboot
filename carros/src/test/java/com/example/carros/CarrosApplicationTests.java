package com.example.carros;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static junit.framework.TestCase.*;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarrosApplicationTests {

    @Autowired
    private CarroService service;

    @Test
    public void teste1() {
        Carro carro = new Carro();
        carro.setNome("Ferrari");
        carro.setTipo("esportivos");

       CarroDTO c = service.insert(carro);

       assertNotNull(c);

       Long id = c.getId();
       assertNotNull(id);

       //Buscar o objeto
        Optional<CarroDTO> op = service.getCarroById(id);
        assertTrue(op.isPresent());

        c = op.get();
        assertEquals("Ferrari",c.getNome());
        assertEquals("esportivos",c.getTipo());

        //Deletar o objeto
        service.delete(id);

        //Verificar se deletou
        assertFalse(service.getCarroById(id).isPresent());
    }


    @Test
    public void testLista() {
        List<CarroDTO> carros = service.getCarros();
        assertEquals(30, carros.size());

    }

}
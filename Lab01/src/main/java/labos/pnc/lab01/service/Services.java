package labos.pnc.lab01.service;

import labos.pnc.lab01.domain.model.BOW;
import labos.pnc.lab01.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//Capa de logica de negocios
@Service
@RequiredArgsConstructor
public class Services {
    private final ProductRepository productRepository;

    public List<BOW> findAll() {
        return productRepository.findAll();
    }
}

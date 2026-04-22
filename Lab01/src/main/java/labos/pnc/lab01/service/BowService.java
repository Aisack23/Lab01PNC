package labos.pnc.lab01.service;

import labos.pnc.lab01.domain.model.BOW;
import labos.pnc.lab01.repository.BowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //capa de la logica de negocios aqui van los  filtros
@RequiredArgsConstructor
public class BowService {

    private final BowRepository bowRepository;

    // Filtrado por virus
    public List<BOW> findByVirus(String virus) {
        return bowRepository.findAll().stream()
                .filter(bow -> bow.getVirus().equalsIgnoreCase(virus))
                .collect(Collectors.toList());
    }

    // Filtrado por estado
    public List<BOW> findByStatus(String status) {
        return bowRepository.findAll().stream()
                .filter(bow -> bow.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    // Virus activos sin repetir
    public List<String> getUniqueActiveViruses() {
        return bowRepository.findAll().stream()
                .filter(bow -> "Free".equalsIgnoreCase(bow.getStatus()))
                .map(BOW::getVirus)
                .distinct() // elimina duplicados
                .collect(Collectors.toList());
    }
}
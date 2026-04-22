package labos.pnc.lab01.repository;

import labos.pnc.lab01.common.SpecimensList;
import labos.pnc.lab01.domain.model.BOW;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Define esta clase como un Bean de la capa de persistencia
@RequiredArgsConstructor // Genera el constructor para la inyección de specimensList
public class BowRepository {

    private final SpecimensList specimensList;

    public List<BOW> findAll() { // Accedemos a la lista de especímenes
        return specimensList.getSpecimens();
    }
}
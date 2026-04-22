package labos.pnc.lab01.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //crea todos los getters y setters
@Builder //crea clases de manera mas sencilla
@AllArgsConstructor //crea constructores con todos los atributos de la clase base
@NoArgsConstructor //crea un constrcutor vacio sin atributos de la clase
public class BOW {
    private Long id;
    private String name;
    private String virus;
    private int danger;
    private String weakness;
    private String status;
    private String lastLocation;
    private String originPossibleLocation;
}

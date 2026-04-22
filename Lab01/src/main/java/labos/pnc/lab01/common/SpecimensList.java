package labos.pnc.lab01.common;

import labos.pnc.lab01.domain.model.BOW;
import lombok.Getter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class SpecimensList {
    private final List<BOW> specimens;

    public SpecimensList() {
        this.specimens = new ArrayList<>();

        this.specimens.add(BOW.builder()
                .id(1L)
                .name("Licker")
                .virus("Cadou")
                .danger(4)
                .weakness("Head")
                .status("Free")
                .lastLocation("Main road")
                .originPossibleLocation("Lab 07")
                .build());

        this.specimens.add(BOW.builder()
                .id(2L)
                .name("Hunter")
                .virus("T-Virus")
                .danger(3)
                .weakness("Neck")
                .status("Content")
                .lastLocation("Mantion")
                .originPossibleLocation("Auditorium")
                .build());

        this.specimens.add(BOW.builder()
                .id(3L)
                .name("Tyrant")
                .virus("G-Virus")
                .danger(5)
                .weakness("Heart")
                .status("Free")
                .lastLocation("Lab")
                .originPossibleLocation("CafeUca")
                .build());

        this.specimens.add(BOW.builder()
                .id(4L)
                .name("Licker")
                .virus("T-Virus")
                .danger(1)
                .weakness("Fire")
                .status("Death")
                .lastLocation("Twon")
                .originPossibleLocation("Biblio")
                .build());
    }

}
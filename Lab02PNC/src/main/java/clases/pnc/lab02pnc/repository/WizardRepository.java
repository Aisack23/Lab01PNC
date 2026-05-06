package clases.pnc.lab02pnc.repository;

import clases.pnc.lab02pnc.domain.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WizardRepository extends JpaRepository<Wizard, UUID> {

    List<Wizard> findByIsDeatheaterTrue();

    List<Wizard> findByPatronus(String patronus);
}
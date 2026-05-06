package clases.pnc.lab02pnc.service;

import clases.pnc.lab02pnc.domain.entity.Wizard;

import java.util.List;
import java.util.UUID;

public interface WizardService {

    Wizard createWizard(Wizard wizard);

    List<Wizard> getAll();

    List<Wizard> getDeatheaters();

    List<Wizard> getByPatronus(String patronus);

    Wizard updateWizard(UUID id, Wizard wizard);

    void deleteWizard(UUID id);
}
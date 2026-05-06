package clases.pnc.lab02pnc.service.impl;

import clases.pnc.lab02pnc.domain.entity.Wizard;
import clases.pnc.lab02pnc.repository.WizardRepository;
import clases.pnc.lab02pnc.service.WizardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {

    private final WizardRepository wizardRepository;

    @Override
    public Wizard createWizard(Wizard wizard) {
        return wizardRepository.save(wizard);
    }

    @Override
    public List<Wizard> getAll() {
        return wizardRepository.findAll();
    }

    @Override
    public List<Wizard> getDeatheaters() {
        return wizardRepository.findByIsDeatheaterTrue();
    }

    @Override
    public List<Wizard> getByPatronus(String patronus) {
        return wizardRepository.findByPatronus(patronus);
    }

    @Override
    public Wizard updateWizard(UUID id, Wizard wizard) {
        Wizard existing = wizardRepository.findById(id).orElseThrow();

        existing.setName(wizard.getName());
        existing.setHouse(wizard.getHouse());
        existing.setPatronus(wizard.getPatronus());
        existing.setIsDeatheater(wizard.getIsDeatheater());

        return wizardRepository.save(existing);
    }

    @Override
    public void deleteWizard(UUID id) {
        wizardRepository.deleteById(id);
    }
}
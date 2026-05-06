package clases.pnc.lab02pnc.service.impl;

import clases.pnc.lab02pnc.domain.entity.Wizard;
import clases.pnc.lab02pnc.repository.WizardRepository;
import clases.pnc.lab02pnc.service.WizardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {
    private final WizardRepository wizardRepository;

    @Override
    public void createWizard(Wizard wizard) {
        wizardRepository.save(wizard);
    }
}

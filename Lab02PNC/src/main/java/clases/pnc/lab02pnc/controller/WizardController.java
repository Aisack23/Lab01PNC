package clases.pnc.lab02pnc.controller;

import clases.pnc.lab02pnc.domain.entity.Wizard;
import clases.pnc.lab02pnc.service.impl.WizardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wizards")
@AllArgsConstructor
public class WizardController {
    private final WizardServiceImpl wizardService;

    @PostMapping("/create")
    public ResponseEntity<Wizard> createWizard(@RequestBody Wizard wizard) {
        wizardService.createWizard(wizard);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(wizard);
    }
}
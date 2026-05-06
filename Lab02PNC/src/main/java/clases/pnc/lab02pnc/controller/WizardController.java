package clases.pnc.lab02pnc.controller;

import clases.pnc.lab02pnc.domain.entity.Wizard;
import clases.pnc.lab02pnc.service.impl.WizardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/wizards")
@AllArgsConstructor
public class WizardController {

    private final WizardServiceImpl wizardService;

    @PostMapping
    public ResponseEntity<Wizard> createWizard(@RequestBody Wizard wizard) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(wizardService.createWizard(wizard));
    }

    @GetMapping
    public ResponseEntity<List<Wizard>> getAll() {
        return ResponseEntity.ok(wizardService.getAll());
    }

    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeatheaters() {
        return ResponseEntity.ok(wizardService.getDeatheaters());
    }

    @GetMapping("/patronus/{patronus}")
    public ResponseEntity<List<Wizard>> getByPatronus(@PathVariable String patronus) {
        return ResponseEntity.ok(wizardService.getByPatronus(patronus));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wizard> updateWizard(
            @PathVariable UUID id,
            @RequestBody Wizard wizard
    ) {
        return ResponseEntity.ok(wizardService.updateWizard(id, wizard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWizard(@PathVariable UUID id) {
        wizardService.deleteWizard(id);
        return ResponseEntity.noContent().build();
    }
}
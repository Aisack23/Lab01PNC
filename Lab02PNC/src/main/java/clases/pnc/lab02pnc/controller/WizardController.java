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
@RequestMapping("/api/productos")
@AllArgsConstructor
public class WizardController {
    private final WizardServiceImpl productService;

    @PostMapping("/create")
    public ResponseEntity<Wizard> createProduct(@RequestBody Wizard wizard) {
        productService.createWizard(wizard);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(wizard);
    }
}
package br.com.alfatecmarine.consultaCNPJ.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alfatecmarine.consultaCNPJ.service.ParceiroService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/parceiros")
@RequiredArgsConstructor
public class ParceiroController {
    
    private final ParceiroService service;

    @GetMapping("/{cnpj}")
    @Operation(summary = "Consulta CNPJ", description = "Realiza uma busca através do CNPJ e retorna CNPJ, Razão Social e Nome Fantasia da empresa.")
    public String procurarCnpj(@PathVariable String cnpj, boolean s) {
        return service.buscarCnpjBrasilApi(cnpj, s);
    }   
}

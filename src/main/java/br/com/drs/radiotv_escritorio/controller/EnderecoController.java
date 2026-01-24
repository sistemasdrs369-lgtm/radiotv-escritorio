package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Endereco;
import br.com.drs.radiotv_escritorio.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> buscar(@PathVariable String cep) {
        Endereco endereco = cepService.buscarPorCep(cep);

        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.notFound().build();
    }
}
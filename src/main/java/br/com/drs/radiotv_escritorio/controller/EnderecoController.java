package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.dto.EnderecoDTO;
import br.com.drs.radiotv_escritorio.dto.EnderecoInputDTO;
import br.com.drs.radiotv_escritorio.dto.ViaCepResponseDTO;
import br.com.drs.radiotv_escritorio.service.EnderecoService;
import br.com.drs.radiotv_escritorio.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final ViaCepService viaCepService;
    private final EnderecoService enderecoService;

    @GetMapping("/cep/{cep}")
    public ViaCepResponseDTO buscarPorCep(@PathVariable String cep) {
        return viaCepService.buscarEnderecoPorCep(cep);
    }

    @PostMapping
    public EnderecoDTO salvar(@RequestBody EnderecoInputDTO dto) {
        return enderecoService.salvarComCep(dto);
    }
}

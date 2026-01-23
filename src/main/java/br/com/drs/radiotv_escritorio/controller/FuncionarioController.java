package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import br.com.drs.radiotv_escritorio.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @GetMapping("/celular")
    public ResponseEntity<Funcionario> buscarPorCelular(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.buscarPorCelular(funcionario));
    }

    @GetMapping("/nome")
    public ResponseEntity<Funcionario> buscarPorNome(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.buscarPorNome(funcionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.atualizarFuncionario(id, funcionario));
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Funcionario> inativar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.inativarFuncionario(id, funcionario));
    }
}

package br.com.drs.radiotv_escritorio.controller;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import br.com.drs.radiotv_escritorio.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
        return service.salvarFuncionario(funcionario);
    }

    @GetMapping("/{id}")
    public Funcionario buscarFuncionarioPorId(Long id) {
        return service.buscarFuncionarioPorId(id);
    }

    @GetMapping
    public List<Funcionario> buscarTodosFuncionarios() {
        return service.buscarTodosFuncionarios();
    }

    @PutMapping
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
        return service.atualizarFuncionario(id, funcionarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(Long id) {
        service.deletarFuncionario(id);
    }
}

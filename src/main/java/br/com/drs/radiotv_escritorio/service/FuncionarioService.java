package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import br.com.drs.radiotv_escritorio.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public List<Funcionario> buscarTodosFuncionarios() {
        return repository.findAll();
    }

    public Funcionario atualizarFuncionario(Long id, @RequestBody Funcionario funcionarioAtualizado) {
        Funcionario funcionarioExistente = buscarFuncionarioPorId(id);
        funcionarioExistente.setNome(funcionarioAtualizado.getNome());
        return repository.save(funcionarioExistente);
    }

    public void deletarFuncionario(Long id) {
        Funcionario funcionarioExistente = buscarFuncionarioPorId(id);
        repository.delete(funcionarioExistente);
    }
}

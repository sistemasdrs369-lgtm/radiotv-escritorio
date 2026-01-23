package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Funcionario;
import br.com.drs.radiotv_escritorio.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public Funcionario buscarPorCelular(Funcionario funcionario) {
        funcionarioRepository.findByCelular(funcionario.getCelular());
        return funcionario;
    }

    public Funcionario buscarPorNome(Funcionario funcionario) {
        funcionarioRepository.findByNomeFuncionario(funcionario.getNomeFuncionario());
        return funcionario;
    }

    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if(funcionario.getId() == null) {
            throw new EntityNotFoundException("Funcionario não encontrado para o id :" + funcionario.getId());
        }
        funcionario.setId(id);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public Funcionario inativarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if(funcionario.getId() == null) {
            throw new EntityNotFoundException("Funcionario não encontrado para o id :" + funcionario.getId());
        }
        funcionario.setAtivo(false);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }
}

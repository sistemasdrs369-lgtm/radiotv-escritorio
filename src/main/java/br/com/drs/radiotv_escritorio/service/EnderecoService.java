package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.EnderecoDTO;
import br.com.drs.radiotv_escritorio.dto.EnderecoInputDTO;
import br.com.drs.radiotv_escritorio.dto.ViaCepResponseDTO;
import br.com.drs.radiotv_escritorio.mapper.EnderecoMapper;
import br.com.drs.radiotv_escritorio.model.Endereco;
import br.com.drs.radiotv_escritorio.model.Funcionario;
import br.com.drs.radiotv_escritorio.repository.EnderecoRepository;
import br.com.drs.radiotv_escritorio.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ViaCepService viaCepService;
    private final EnderecoMapper enderecoMapper;

    public EnderecoDTO salvarComCep(EnderecoInputDTO dto) {

        Funcionario funcionario = funcionarioRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        ViaCepResponseDTO viaCep = viaCepService.buscarEnderecoPorCep(dto.getCep());

        if (viaCep == null || Boolean.TRUE.equals(viaCep.getErro())) {
            throw new RuntimeException("CEP inválido");
        }

        Endereco endereco = new Endereco();
        endereco.setFuncionario(funcionario);
        endereco.setCep(dto.getCep());
        endereco.setNumero(dto.getNumero());
        endereco.setComplemento(dto.getComplemento());

        // preenchimento automático
        endereco.setLogradouro(viaCep.getLogradouro());
        endereco.setBairro(viaCep.getBairro());
        endereco.setLocalidade(viaCep.getLocalidade());
        endereco.setUf(viaCep.getUf());

        return enderecoMapper.toDto(enderecoRepository.save(endereco));
    }
}



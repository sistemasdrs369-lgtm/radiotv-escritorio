package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.dto.EnderecoDTO;
import br.com.drs.radiotv_escritorio.mapper.EnderecoMapper;
import br.com.drs.radiotv_escritorio.model.Endereco;
import br.com.drs.radiotv_escritorio.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;
    private final RestTemplate restTemplate = new RestTemplate(); // Pode ser um Bean configurado

    public EnderecoDTO salvar(EnderecoDTO dto) {
        // 1. Busca os dados pelo CEP na API ViaCEP
        String url = "https://viacep.com.br/ws/" + dto.getCep() + "/json/";
        try {
            EnderecoDTO dadosCep = restTemplate.getForObject(url, EnderecoDTO.class);

            if (dadosCep != null && dadosCep.getLogradouro() != null) {
                // 2. Preenche os campos automáticos mantendo o que o usuário enviou (numero/complemento)
                dto.setLogradouro(dadosCep.getLogradouro());
                dto.setBairro(dadosCep.getBairro());
                dto.setLocalidade(dadosCep.getLocalidade());
                dto.setUf(dadosCep.getUf());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar CEP: " + e.getMessage());
        }

        // 3. Converte e Salva
        Endereco endereco = mapper.toEntity(dto);
        return mapper.toDto(repository.save(endereco));
    }

    public List<EnderecoDTO> listarTodos() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public EnderecoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public EnderecoDTO atualizar(Long id, EnderecoDTO dto) {
        if (!repository.existsById(id)) throw new RuntimeException("ID não encontrado");
        Endereco endereco = mapper.toEntity(dto);
        endereco.setId(id);
        return mapper.toDto(repository.save(endereco));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
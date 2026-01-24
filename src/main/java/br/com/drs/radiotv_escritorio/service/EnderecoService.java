package br.com.drs.radiotv_escritorio.service;

import br.com.drs.radiotv_escritorio.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Endereco buscarPorCep(String cep) {
        try {
            String url = "https://viacep.com.br/ws/" + cep.replaceAll("\\D", "") + "/json/";
            // O RestTemplate já usa o Jackson do Spring para converter automaticamente
            Endereco endereco = restTemplate.getForObject(url, Endereco.class);

            if (endereco != null && (endereco.getErro() == null || !endereco.getErro())) {
                return endereco;
            }
        } catch (Exception e) {
            System.err.println("Erro na busca: " + e.getMessage());
        }
        return null;
    }
}
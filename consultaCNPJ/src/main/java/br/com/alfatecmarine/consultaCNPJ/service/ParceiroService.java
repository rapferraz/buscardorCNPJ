package br.com.alfatecmarine.consultaCNPJ.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alfatecmarine.consultaCNPJ.DTO.BrasilApiCnpjDTO;
import br.com.alfatecmarine.consultaCNPJ.exception.DuplicataException;
import br.com.alfatecmarine.consultaCNPJ.model.Parceiro;
import br.com.alfatecmarine.consultaCNPJ.repository.ParceiroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParceiroService {

    private final RestTemplate restTemplate;
    private final ParceiroRepository repository;

    public List<Parceiro> listarBanco() {
        return repository.findAll();
    }

    public String buscarCnpjBrasilApi(String cnpj, boolean salvar) {

        String url = "https://brasilapi.com.br/api/cnpj/v1/" + cnpj;

        ResponseEntity<BrasilApiCnpjDTO> response = restTemplate.getForEntity(url, BrasilApiCnpjDTO.class);

        BrasilApiCnpjDTO body = Optional.ofNullable(response.getBody())
            .orElseThrow(() -> new RuntimeException("Dados da API estão nulos"));

        Parceiro a = new Parceiro(body.getCnpj(), body.getRazaoSocial(), body.getNomeFantasia());

        // se o nome fantasia vier nulo ou vazio recebe "-" para não ficar em branco.
        if (body.getNomeFantasia() == null || body.getNomeFantasia().isEmpty()) {
            a.setNomeFantasia("-");
        }

        // se o parâmetro for passado como verdadeiro, verifica se já existe e então salva no banco de dados.
        if (salvar) {
            if (repository.existsByCnpj(body.getCnpj())) {
                throw new DuplicataException("AVISO: CNPJ já cadastrado no sistema!\n" + a.toString());
            }

            repository.save(a);
        }

        return a.toString();
    }
}
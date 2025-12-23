package br.com.alfatecmarine.consultaCNPJ.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrasilApiCnpjDTO {

    @JsonProperty("cnpj")
    String cnpj;

    @JsonProperty("razao_social")
    String razaoSocial;
    
    @JsonProperty("nome_fantasia")
    String nomeFantasia;
}

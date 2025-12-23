package br.com.alfatecmarine.consultaCNPJ.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parceiro")
@AllArgsConstructor
@NoArgsConstructor
public class Parceiro {
    
    @Id
    @Column(length = 14, nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String razaoSocial;

    @Column
    private String nomeFantasia;

    public String getCnpj() {
        return Formatador.formataCnpj(this.cnpj);
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return "CNPJ: " + getCnpj()
            + "\nRazão Social: " + getRazaoSocial()
            + "\nNome Fantasia: " + getNomeFantasia();
    }
}

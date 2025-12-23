package br.com.alfatecmarine.consultaCNPJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alfatecmarine.consultaCNPJ.model.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, String> {

    public boolean existsByCnpj(String cnpj);
}
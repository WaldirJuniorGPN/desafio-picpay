package br.com.desafio_picpay.desafio_pickpay.domain.usuario;

import br.com.desafio_picpay.desafio_pickpay.domain.exception.RegraDeNegocioException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity(name = "Lojista")
@Table(name = "lojista")
@EqualsAndHashCode(callSuper = true)
public class Lojista extends Usuario {

    @Getter
    @Column(nullable = false, length = 14, unique = true)
    private String cnpj;

    public void setCnpj(String cnpj) {
        if (cnpj == null || cnpj.isBlank()) {
            throw new RegraDeNegocioException("CNPJ não pode ser nulo ou estar em branco");
        }

        if (!cnpj.matches("\\d{14}")) {
            throw new RegraDeNegocioException("CNPJ deve conter 14 dígitos");
        }

        this.cnpj = cnpj;
    }
}

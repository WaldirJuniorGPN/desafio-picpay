package br.com.desafio_picpay.desafio_pickpay.domain.usuario;

import br.com.desafio_picpay.desafio_pickpay.domain.exception.RegraDeNegocioException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity(name = "UsuarioComum")
@Table(name = "usuario_comum")
@EqualsAndHashCode(callSuper = true)
public class UsuarioComum extends Usuario {

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    public void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new RegraDeNegocioException("CPF não pode ser nulo ou estar em branco");
        }

        if (!cpf.matches("\\d{11}")) {
            throw new RegraDeNegocioException("CPF deve conter 11 dígitos");
        }

        this.cpf = cpf;
    }
}

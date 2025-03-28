package br.com.desafio_picpay.desafio_pickpay.domain.usuario;

import br.com.desafio_picpay.desafio_pickpay.domain.exception.RegraDeNegocioException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "UsuarioComum")
@Table(name = "usuario_comum")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UsuarioComum extends Usuario {

    public UsuarioComum(String nomeCompleto, String email, String senha, String cpf) {
        setNomeCompleto(nomeCompleto);
        setEmail(email);
        setSenha(senha);
        setCpf(cpf);
    }

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    private void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new RegraDeNegocioException("CPF não pode ser nulo ou estar em branco");
        }

        if (!cpf.matches("\\d{11}")) {
            throw new RegraDeNegocioException("CPF deve conter 11 dígitos");
        }

        this.cpf = cpf;
    }
}
